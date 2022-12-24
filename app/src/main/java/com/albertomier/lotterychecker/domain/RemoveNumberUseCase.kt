package com.albertomier.lotterychecker.domain

import com.albertomier.lotterychecker.data.AppRepository
import javax.inject.Inject

class RemoveNumberUseCase @Inject constructor(private val repository: AppRepository) {

    suspend operator fun invoke(number: String) {
        repository.removeNumber(number)
    }
}