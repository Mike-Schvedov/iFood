package com.mikeschvedov.ifood.data.local_data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mikeschvedov.ifood.data.local_data.database.daos.FoodEntryDao
import com.mikeschvedov.ifood.data.local_data.database.entities.FoodEntry

@Database(entities = [FoodEntry::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun foodEntryDao(): FoodEntryDao
}