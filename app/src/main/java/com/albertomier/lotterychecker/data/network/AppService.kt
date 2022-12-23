package com.albertomier.lotterychecker.data.network

import android.util.Log
import com.albertomier.lotterychecker.core.extensions.numberResponse
import com.albertomier.lotterychecker.data.model.ApiResponse
import com.albertomier.lotterychecker.data.model.NumberResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class AppService @Inject constructor(private val api: ApiClient) {

    suspend fun checkNumber(number: String): NumberResponse {
        return withContext(Dispatchers.IO) {
            val response: String = api.checkNumber(number)
            val result = response.replace("busqueda=", "").numberResponse()

            result!!
        }
    }
}