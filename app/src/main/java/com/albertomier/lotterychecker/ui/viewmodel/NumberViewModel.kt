package com.albertomier.lotterychecker.ui.viewmodel

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertomier.lotterychecker.core.extensions.toast
import com.albertomier.lotterychecker.data.network.ApiResponseStatus
import com.albertomier.lotterychecker.domain.AddNumberUseCase
import com.albertomier.lotterychecker.domain.CheckNumberUseCase
import com.albertomier.lotterychecker.domain.GetNumbersUseCase
import com.albertomier.lotterychecker.domain.RemoveNumberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import javax.inject.Inject

@HiltViewModel
class NumberViewModel @Inject constructor(
    private val checkNumberUseCase: CheckNumberUseCase,
    private val getNumberUseCase: GetNumbersUseCase,
    private val addNumberUseCase: AddNumberUseCase,
    private val removeNumberUseCase: RemoveNumberUseCase
) : ViewModel() {

    private val _number = MutableLiveData<com.albertomier.lotterychecker.domain.model.Number>()
    val number: LiveData<com.albertomier.lotterychecker.domain.model.Number> get() = _number

    private val _numberList =
        MutableLiveData<List<com.albertomier.lotterychecker.domain.model.Number>>()
    val numberList: LiveData<List<com.albertomier.lotterychecker.domain.model.Number>> get() = _numberList

    private val _status = MutableLiveData<ApiResponseStatus<Any>>()
    val status: LiveData<ApiResponseStatus<Any>> get() = _status

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun checkNumber(number: String) {
        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading()
            handleResponseStatus(checkNumberUseCase(number))
        }
    }

    fun getNumbers() {
        viewModelScope.launch {
            _loading.value = true

            Log.e("TAG", "Call getNumbers(): start")
            val result = getNumberUseCase()

            _numberList.value = result
            _loading.value = false
        }
    }

    fun addNumber(number: String, image: Bitmap, context: Context) {
        viewModelScope.launch {
            val img = saveMediaToStorage(image, context)
            addNumberUseCase(number, img)
            getNumbers()
        }
    }

    fun removeNumber(number: String) {
        viewModelScope.launch {
            removeNumberUseCase(number)
            getNumbers()
        }
    }

    private fun handleResponseStatus(responseStatus: ApiResponseStatus<com.albertomier.lotterychecker.domain.model.Number>) {
        if (responseStatus is ApiResponseStatus.Success) {
            _number.value = responseStatus.data
        }

        _status.value = responseStatus as ApiResponseStatus<Any>
    }

    private fun saveMediaToStorage(bitmap: Bitmap, context: Context): String {
        val filename = "${System.currentTimeMillis()}.jpg"
        var fos: OutputStream? = null

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            context.contentResolver?.also { resolver ->
//                val contentValues = ContentValues().apply {
//                    put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
//                    put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
//                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
//                }
//
//                val imageUri: Uri? =
//                    resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
//
//                fos = imageUri?.let { resolver.openOutputStream(it) }
//
//                //return imageUri.path!!
//            }
//        } else {
            val imagesDir =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            val image = File(imagesDir, filename)

            fos = FileOutputStream(image)

            Log.e("TAGGG", image.absolutePath)

            //return image.absolutePath
        //}

        fos.use {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
            context.toast("Saved to Photos")
        }

       // Log.e("TAGGG", fos)

        return image.absolutePath
    }
}