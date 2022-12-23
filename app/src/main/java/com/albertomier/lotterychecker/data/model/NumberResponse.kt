package com.albertomier.lotterychecker.data.model

import com.google.gson.annotations.SerializedName

data class NumberResponse(
    @SerializedName("numero") val number: String,
    @SerializedName("premio") val prize: Int,
    @SerializedName("timestamp") val timestamp: Int,
    @SerializedName("status") val status: Int,
    @SerializedName("error") val error: Int
)