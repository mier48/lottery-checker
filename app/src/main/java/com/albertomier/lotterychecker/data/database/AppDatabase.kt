package com.albertomier.lotterychecker.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.albertomier.lotterychecker.data.database.dao.AppDao
import com.albertomier.lotterychecker.data.database.entities.NumberEntity

@Database(entities = [NumberEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getAppDao(): AppDao
}