package com.albertomier.lotterychecker.domain.model

import android.graphics.Bitmap
import android.os.Parcelable
import com.albertomier.lotterychecker.data.database.entities.NumberEntity
import com.albertomier.lotterychecker.data.model.NumberResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class Number(
    val number: String,
    val prize: Int,
    val timestamp: Int,
    val status: Int,
    val error: Int,
    val image: String?,
    val createdAt: String
) : Parcelable {

}

fun NumberResponse.toDomain() =
    Number(
        number,
        prize,
        timestamp,
        status,
        error,
        null,
        ""
    )

fun NumberEntity.toDomain() =
    Number(
        number,
        prize,
        timestamp,
        status,
        error,
        image,
        createdAt
    )
