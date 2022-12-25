package com.albertomier.lotterychecker.domain

import com.albertomier.lotterychecker.data.AppRepository
import com.albertomier.lotterychecker.data.network.ApiResponseStatus
import com.albertomier.lotterychecker.domain.model.Number
import javax.inject.Inject

class GetNumbersUseCase @Inject constructor(private val repository: AppRepository) {

    suspend operator fun invoke(): List<Number> = repository.getNumbers()
}