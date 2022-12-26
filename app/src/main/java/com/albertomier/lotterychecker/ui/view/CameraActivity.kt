package com.albertomier.lotterychecker.ui.view

import android.Manifest
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.camera.core.*
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Lens
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.albertomier.lotterychecker.R
import com.albertomier.lotterychecker.core.extensions.isNumeric
import com.albertomier.lotterychecker.core.interfaces.PermissionsCallback
import com.albertomier.lotterychecker.core.utils.AppThemeState
import com.albertomier.lotterychecker.core.utils.ManagePermissions
import com.albertomier.lotterychecker.core.utils.SystemUiController
import com.albertomier.lotterychecker.core.utils.getCameraProvider
import com.albertomier.lotterychecker.ui.theme.LotteryCheckerTheme
import com.albertomier.lotterychecker.ui.theme.appBarDarkBlackDark
import com.albertomier.lotterychecker.ui.theme.appScaffoldColor
import com.albertomier.lotterychecker.ui.viewmodel.NumberViewModel
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@ExperimentalGetImage
@AndroidEntryPoint
class CameraActivity : ComponentActivity() {

    private lateinit var outputDirectory: File
    private lateinit var capturedImage: Bitmap
    private lateinit var fileDirectory: String
    private lateinit var cameraExecutor: ExecutorService
    private lateinit var numberScan: MutableState<String>
    private lateinit var openDialog: MutableState<Boolean>

    private var shouldShowCamera: MutableState<Boolean> = mutableStateOf(false)
    private var shouldShowPhoto: MutableState<Boolean> = mutableStateOf(false)

    private val viewModel: NumberViewModel by viewModels()

    private val permissionsRequestCode = 123
    private lateinit var managePermissions: ManagePermissions

    private val list = listOf(
        Manifest.permission.CAMERA,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    private fun handleImageCapture(image: Bitmap) {
        capturedImage = image
    }

    private fun getOutputDirectory(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }

        return if (mediaDir != null && mediaDir.exists()) mediaDir else filesDir
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            openDialog = remember { mutableStateOf(false) }
            numberScan = remember { mutableStateOf("") }

            val systemUiController = remember { SystemUiController(window) }
            val appTheme = remember { mutableStateOf(AppThemeState()) }

            CameraBaseView(appTheme.value, systemUiController) {
                CameraBody(viewModel = viewModel)
            }
        }

        managePermissions = ManagePermissions(this, list, permissionsRequestCode)
        managePermissions.checkPermissions(object : PermissionsCallback {
            override fun onSuccess() {
                shouldShowCamera.value = true
            }

            override fun onError() {
                shouldShowCamera.value = false
            }
        })

        outputDirectory = getOutputDirectory()
        cameraExecutor = Executors.newSingleThreadExecutor()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        managePermissions.processPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun takePhoto(
        imageCapture: ImageCapture,
        executor: Executor,
        onImageCaptured: (Bitmap) -> Unit,
        onError: (ImageCaptureException) -> Unit
    ) {
        imageCapture.takePicture(executor, object : ImageCapture.OnImageCapturedCallback() {
            override fun onCaptureSuccess(img: ImageProxy) {
                val mediaImage = img.image
                if (mediaImage != null) {
                    val image = FirebaseVisionImage.fromMediaImage(mediaImage, 0)
                    val detector = FirebaseVision.getInstance().onDeviceTextRecognizer
                    val bitmap = image.bitmap

                    onImageCaptured(bitmap)

                    detector.processImage(image)
                        .addOnSuccessListener { firebaseVisionText ->
                            val resultText = firebaseVisionText.text
                            checkNumber(resultText)

                            for (block in firebaseVisionText.textBlocks) {
                                checkNumber(block.text)

                                for (line in block.lines) {
                                    checkNumber(line.text)
                                }
                            }
                        }
                        .addOnFailureListener { e -> Log.e("TAG", e.message!!) }
                }
            }

            override fun onError(exception: ImageCaptureException) {
                onError(exception)
            }
        })
    }

    private fun checkNumber(text: String) {
        if (text.isNumeric()) {
            if (text.length == 5) {
                numberScan.value = text
                openDialog.value = true
                shouldShowPhoto.value = true
            }
        }
    }

    @Composable
    fun CameraView(
        executor: Executor,
        onImageCaptured: (Bitmap) -> Unit,
        onError: (ImageCaptureException) -> Unit
    ) {
        val lensFacing = CameraSelector.LENS_FACING_BACK
        val context = LocalContext.current
        val lifecycleOwner = LocalLifecycleOwner.current

        val preview = Preview.Builder().build()
        val previewView = remember { PreviewView(context) }
        val imageCapture: ImageCapture = remember { ImageCapture.Builder().build() }
        val cameraSelector = CameraSelector.Builder().requireLensFacing(lensFacing).build()

        LaunchedEffect(lensFacing) {
            val cameraProvider = context.getCameraProvider()
            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(
                lifecycleOwner,
                cameraSelector,
                preview,
                imageCapture
            )

            preview.setSurfaceProvider(previewView.surfaceProvider)
        }

        Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) {
            AndroidView({ previewView }, modifier = Modifier.fillMaxSize())

            IconButton(
                modifier = Modifier.padding(bottom = 20.dp),
                onClick = {
                    takePhoto(
                        imageCapture = imageCapture,
                        executor = executor,
                        onImageCaptured = onImageCaptured,
                        onError = onError
                    )
                },
                content = {
                    Icon(
                        imageVector = Icons.Sharp.Lens,
                        contentDescription = "Take picture",
                        tint = Color.White,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(1.dp)
                            .border(1.dp, Color.White, CircleShape)
                    )
                }
            )
        }
    }

    @Composable
    fun CameraBaseView(
        appThemeState: AppThemeState,
        systemUiController: SystemUiController?,
        content: @Composable () -> Unit
    ) {
        systemUiController?.setStatusBarColor(
            color = if (appThemeState.darkTheme) appBarDarkBlackDark else appScaffoldColor,
            darkIcons = !appThemeState.darkTheme
        )

        LotteryCheckerTheme(
            darkTheme = appThemeState.darkTheme,
            colorPallet = appThemeState.pallet
        ) {
            content()
        }
    }

    @Composable
    fun CameraBody(viewModel: NumberViewModel) {
        val context = LocalContext.current

        if (shouldShowCamera.value) {
            CameraView(
                executor = cameraExecutor,
                onImageCaptured = ::handleImageCapture,
            ) { }
        }
        if (shouldShowPhoto.value) {
            Image(
                bitmap = capturedImage.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    openDialog.value = false
                },
                title = {
                    Text(text = "Lectura finalizada", style = boldTextStyle())
                },
                text = {
                    val txt = numberScan.value
                    Text("El número: $txt es correcto?", style = secondaryTextStyle())
                },
                confirmButton = {
                    Button(onClick = {
                        openDialog.value = false
                        viewModel.addNumber(numberScan.value, capturedImage, context)
                        finish()
                    }, modifier = Modifier.background(MaterialTheme.colors.primary)) { Text("Si") }
                },
                dismissButton = {
                    Button(onClick = {
                        openDialog.value = false
                    }, modifier = Modifier.background(MaterialTheme.colors.primary)) { Text("No") }
                }
            )
        }
    }
}