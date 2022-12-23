package com.albertomier.lotterychecker.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "numbers")
data class NumberEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "numero") var number: String,
    @ColumnInfo(name = "premio") var prize: Int,
    @ColumnInfo(name = "timestamp") var timestamp: Int,
    @ColumnInfo(name = "status") var status: Int,
    @ColumnInfo(name = "error") var error: Int,
    @ColumnInfo(name = "created_at") var createdAt: String
)