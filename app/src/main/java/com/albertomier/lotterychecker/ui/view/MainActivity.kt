package com.albertomier.lotterychecker.ui.view

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.camera.core.ExperimentalGetImage
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.albertomier.lotterychecker.R
import com.albertomier.lotterychecker.core.extensions.Height
import com.albertomier.lotterychecker.core.extensions.Width
import com.albertomier.lotterychecker.core.extensions.formatDate
import com.albertomier.lotterychecker.core.extensions.radius
import com.albertomier.lotterychecker.core.utils.AppThemeState
import com.albertomier.lotterychecker.core.utils.SystemUiController
import com.albertomier.lotterychecker.data.network.ApiResponseStatus
import com.albertomier.lotterychecker.domain.model.Number
import com.albertomier.lotterychecker.ui.theme.LotteryCheckerTheme
import com.albertomier.lotterychecker.ui.theme.appBarDarkBlackDark
import com.albertomier.lotterychecker.ui.theme.appScaffoldColor
import com.albertomier.lotterychecker.ui.viewmodel.NumberViewModel
import com.google.android.gms.ads.*
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@ExperimentalGetImage
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: NumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MobileAds.initialize(this)

        setContent {
            val systemUiController = remember { SystemUiController(window) }
            val appTheme = remember { mutableStateOf(AppThemeState()) }

            BaseView(appTheme.value, systemUiController) {
                Body(viewModel = viewModel)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getNumbers()
    }
}

@Composable
fun BaseView(
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

@androidx.annotation.OptIn(androidx.camera.core.ExperimentalGetImage::class)
@Composable
fun Body(viewModel: NumberViewModel) {
    val context = LocalContext.current

    viewModel.getNumbers()

    val shouldShowProgressIndicator = remember { mutableStateOf(false) }
    val status by viewModel.status.observeAsState(initial = ApiResponseStatus.Stop())
    val numberList: List<Number> by viewModel.numberList.observeAsState(
        initial = emptyList()
    )

    when (status) {
        is ApiResponseStatus.Error -> {
            shouldShowProgressIndicator.value = false
            Toast.makeText(
                context,
                stringResource(id = (status as ApiResponseStatus.Error<Any>).messageId),
                Toast.LENGTH_LONG
            ).show()
        }
        is ApiResponseStatus.Loading -> {
            shouldShowProgressIndicator.value = true
        }
        is ApiResponseStatus.Success -> {
            shouldShowProgressIndicator.value = false
        }
        is ApiResponseStatus.Stop -> {
            shouldShowProgressIndicator.value = false
        }
    }

    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("+") },
                backgroundColor = Color.Red,
                contentColor = Color.White,
                onClick = {
                    context.startActivity(Intent(context, CameraActivity::class.java))
                }
            )
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = boldTextStyle(fontSize = 18.sp),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.onSurface,
                elevation = 2.dp,
            )
        },
        content = {
            SetContent(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(bottom = it.calculateBottomPadding()),
                viewModel,
                shouldShowProgressIndicator,
                numberList
            )
        })
}

@Composable
fun SetContent(
    modifier: Modifier,
    viewModel: NumberViewModel,
    shouldShowProgressIndicator: MutableState<Boolean>,
    numberList: List<Number>
) {
    Column(modifier = modifier) {
        LazyColumn(contentPadding = PaddingValues(top = 16.dp)) {
            itemsIndexed(numberList) { _, item ->
                ListComponent(item = item, viewModel = viewModel) {}
            }
        }
        BannerAdView()
    }

    if (shouldShowProgressIndicator.value) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray.copy(alpha = 0.8f))
        ) {
            CircularProgressIndicator(modifier = Modifier.size(150.dp))
        }
    }
}

@Composable
fun ItemList(
    item: Number,
    viewModel: NumberViewModel,
    onItemSelected: (item: String) -> Unit
) {
    val prize = item.prize

    Card(
        modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.number,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = "$prize €",
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = item.createdAt.formatDate(),
                textAlign = TextAlign.End,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Row {
                IconButton(onClick = { viewModel.removeNumber(item.number) }) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = null,
                        tint = Color(0xFFFF3300),
                    )
                }
                IconButton(onClick = { viewModel.checkNumber(item.number) }) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = null,
                        tint = Color(0xFF33FF00)
                    )
                }
            }
        }
    }
}

@Composable
fun ListComponent(
    item: Number,
    viewModel: NumberViewModel,
    onItemSelected: (item: String) -> Unit
) {
    var color = Color(0xFFFF3300)
    if (item.prize > 0) {
        color = Color(0xFF33FF00)
    }

    val image: Bitmap? = BitmapFactory.decodeFile(item.image)

    Row(
        modifier = Modifier
            .padding(bottom = 22.dp, start = 16.dp, end = 16.dp)
            .height(110.dp),
        content = {
            if (!item.image.isNullOrEmpty()) {
                Image(
                    bitmap = image!!.asImageBitmap(),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(12.radius())
                        .width(150.dp)
                        .fillMaxSize()
                )
            }
            10.Width()
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 8.dp, bottom = 8.dp),
                content = {
                    Column {
                        Text(item.number, style = boldTextStyle())
                        6.Height()
                        Text(item.createdAt.formatDate(), style = secondaryTextStyle())
                        8.Height()
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth(),
                        content = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                content = {
                                    Icon(
                                        Icons.Filled.Euro,
                                        tint = color,
                                        contentDescription = null,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    4.Width()
                                    Text(item.prize.toString(), style = boldTextStyle(color))
                                    Row(
                                        modifier = Modifier
                                            .padding(2.dp)
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.End
                                    ) {
                                        IconButton(onClick = { viewModel.checkNumber(item.number) }) {
                                            Icon(
                                                imageVector = Icons.Filled.Refresh,
                                                contentDescription = null,
                                                tint = Color(0xFF33FF00)
                                            )
                                        }
                                        IconButton(onClick = { viewModel.removeNumber(item.number) }) {
                                            Icon(
                                                imageVector = Icons.Filled.Delete,
                                                contentDescription = null,
                                                tint = Color(0xFFFF3300),
                                            )
                                        }
                                    }
                                })
                        })
                })
        })
}

@Composable
fun BannerAdView(modifier: Modifier = Modifier) {
    AndroidView(modifier = modifier.fillMaxWidth(), factory = { context ->
        AdView(context).apply {
            setAdSize(AdSize.BANNER)
            adUnitId = context.getString(R.string.banner_block_id)
            loadAd(AdRequest.Builder().build())
        }
    })
}