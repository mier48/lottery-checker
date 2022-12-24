package com.albertomier.lotterychecker.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "numbers", indices = [Index(value = ["numero"], unique = true)])
data class NumberEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "numero") var number: String,
    @ColumnInfo(name = "premio") var prize: Int,
    @ColumnInfo(name = "timestamp") var timestamp: Int,
    @ColumnInfo(name = "status") var status: Int,
    @ColumnInfo(name = "error") var error: Int,
    @ColumnInfo(name = "created_at") var createdAt: String
)

fun com.albertomier.lotterychecker.domain.model.Number.toDatabase() =
    NumberEntity(
        number = number,
        prize = prize,
        timestamp = timestamp,
        status = status,
        error = error,
        createdAt = createdAt
    )