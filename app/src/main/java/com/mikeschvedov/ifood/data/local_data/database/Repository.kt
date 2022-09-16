package com.mikeschvedov.ifood.data.local_data.database

import com.mikeschvedov.ifood.data.local_data.database.entities.FoodEntry
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun addNewEntry(foodEntry: FoodEntry)

    fun getFoodEntriesByDate(day: Int, month: Int, year:Int): Flow<List<FoodEntry>>

    suspend fun deleteEntryFromDB(foodEntry: FoodEntry)
}