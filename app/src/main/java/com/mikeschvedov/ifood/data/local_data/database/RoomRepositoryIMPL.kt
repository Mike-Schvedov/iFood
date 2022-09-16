package com.mikeschvedov.ifood.data.local_data.database

import com.mikeschvedov.ifood.data.local_data.database.daos.FoodEntryDao
import com.mikeschvedov.ifood.data.local_data.database.entities.FoodEntry
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomRepositoryIMPL @Inject constructor(
    private val foodEntryDao: FoodEntryDao
) :Repository {


    override suspend fun addNewEntry(foodEntry: FoodEntry) {
        foodEntryDao.addNewEntry(foodEntry)
    }

    override fun getFoodEntriesByDate(day: Int, month: Int, year:Int): Flow<List<FoodEntry>> {
        return foodEntryDao.getFoodEntriesByDate(day, month, year)
    }

    override suspend fun deleteEntryFromDB(foodEntry: FoodEntry) {
        foodEntryDao.deleteEntry(foodEntry)
    }
}