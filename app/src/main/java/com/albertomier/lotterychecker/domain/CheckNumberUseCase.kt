package com.albertomier.lotterychecker.domain

import com.albertomier.lotterychecker.data.AppRepository
import com.albertomier.lotterychecker.data.network.ApiResponseStatus
import javax.inject.Inject

class CheckNumberUseCase @Inject constructor(private val repository: AppRepository) {
    suspend operator fun invoke(number: String): ApiResponseStatus<com.albertomier.lotterychecker.domain.model.Number> =
        repository.checkNumber(number)
}