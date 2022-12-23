package com.albertomier.lotterychecker.data

import com.albertomier.lotterychecker.data.network.ApiResponseStatus
import com.albertomier.lotterychecker.data.network.AppService
import com.albertomier.lotterychecker.data.network.makeNetworkCall
import com.albertomier.lotterychecker.domain.model.toDomain
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val appService: AppService
) {
    suspend fun checkNumber(number: String): ApiResponseStatus<com.albertomier.lotterychecker.domain.model.Number> = makeNetworkCall {
        val response = appService.checkNumber(number = number)

        response.toDomain()
    }
}