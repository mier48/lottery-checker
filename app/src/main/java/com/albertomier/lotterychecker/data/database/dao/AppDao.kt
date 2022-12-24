package com.albertomier.lotterychecker.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.albertomier.lotterychecker.data.database.entities.NumberEntity

@Dao
interface AppDao {
    @Query("SELECT * FROM numbers ORDER BY id DESC")
    suspend fun getNumbers(): List<NumberEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNumber(number: NumberEntity)

    @Query("DELETE FROM numbers WHERE numero = :number")
    suspend fun removeNumber(number: String)

    @Query("UPDATE numbers SET premio = :prize, created_at = :createdAt WHERE numero = :number")
    suspend fun updateNumber(prize: Int, number: String, createdAt: String)
}