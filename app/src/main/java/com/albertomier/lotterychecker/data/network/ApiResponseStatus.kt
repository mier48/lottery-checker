package com.albertomier.lotterychecker.data.network

sealed class ApiResponseStatus<T> {
    class Stop<T> : ApiResponseStatus<T>()
    class Loading<T> : ApiResponseStatus<T>()
    class Error<T>(val messageId: Int) : ApiResponseStatus<T>()
    class Success<T>(val data: T) : ApiResponseStatus<T>()
}