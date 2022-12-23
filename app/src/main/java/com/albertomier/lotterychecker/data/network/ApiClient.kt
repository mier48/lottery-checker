package com.albertomier.lotterychecker.data.network

import com.albertomier.lotterychecker.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("LoteriaNavidadPremiados")
    suspend fun checkNumber(@Query("n") number: String): String
}