package com.albertomier.lotterychecker.domain.model

import android.os.Parcelable
import com.albertomier.lotterychecker.data.database.entities.NumberEntity
import com.albertomier.lotterychecker.data.model.NumberResponse
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Number(
    val id: Int,
    val number: String,
    val prize: Int,
    val timestamp: Int,
    val status: Int,
    val error: Int,
    val createdAt: String
) : Parcelable {
    constructor(): this(0, "", 0, 0, 0, 0, "")
}

fun NumberResponse.toDomain() =
    Number(
        0,
        number,
        prize,
        timestamp,
        status,
        error,
        ""
    )

fun NumberEntity.toDomain() =
    Number(
        id,
        number,
        prize,
        timestamp,
        status,
        error,
        createdAt
    )
