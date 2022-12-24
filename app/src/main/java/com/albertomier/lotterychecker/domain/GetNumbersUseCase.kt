package com.albertomier.lotterychecker.domain

import android.util.Log
import com.albertomier.lotterychecker.data.AppRepository
import com.albertomier.lotterychecker.domain.model.Number
import javax.inject.Inject

class GetNumbersUseCase @Inject constructor(private val repository: AppRepository) {
    suspend operator fun invoke(): List<Number> {
        val list = repository.getNumbers()

        Log.e("TAGGG", list.toString())

        return list
    }
}