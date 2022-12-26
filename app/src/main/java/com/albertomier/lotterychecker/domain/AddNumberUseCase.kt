package com.albertomier.lotterychecker.domain

import android.graphics.Bitmap
import androidx.compose.ui.graphics.ImageBitmap
import com.albertomier.lotterychecker.data.AppRepository
import com.albertomier.lotterychecker.data.network.ApiResponseStatus
import com.albertomier.lotterychecker.domain.model.Number
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class AddNumberUseCase @Inject constructor(private val repository: AppRepository) {

    suspend operator fun invoke(
        number: String,
        image: String
    ) {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val createdAt: String = sdf.format(Date())

        val result: ApiResponseStatus<Number> = repository.checkNumber(number)

        if (result is ApiResponseStatus.Success) {
            val data: Number = result.data

            val numberModel =
                Number(number, data.prize, data.timestamp, data.status, data.error, image, createdAt)

            repository.addNumber(numberModel)
        }
    }
}