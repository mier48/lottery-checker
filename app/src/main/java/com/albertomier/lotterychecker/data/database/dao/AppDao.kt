package com.albertomier.lotterychecker.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.albertomier.lotterychecker.data.database.entities.NumberEntity

@Dao
interface AppDao {
    @Query("SELECT * FROM numbers ORDER BY created_at DESC")
    suspend fun getNumbers(): NumberEntity
}