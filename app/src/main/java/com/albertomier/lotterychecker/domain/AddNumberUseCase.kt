package com.albertomier.lotterychecker.domain

import com.albertomier.lotterychecker.data.AppRepository
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class AddNumberUseCase @Inject constructor(private val repository: AppRepository) {

    suspend operator fun invoke(
        number: String,
        prize: Int,
        timestamp: Int,
        status: Int,
        error: Int
    ) {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val createdAt: String = sdf.format(Date())

        val numberModel: com.albertomier.lotterychecker.domain.model.Number =
            com.albertomier.lotterychecker.domain.model.Number(
                number,
                prize,
                timestamp,
                status,
                error,
                createdAt
            )
        repository.addNumber(numberModel)
        //repository.checkNumber(number)
    }
}