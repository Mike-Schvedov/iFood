package com.mikeschvedov.ifood.data

import com.mikeschvedov.ifood.data.local_data.database.Repository
import com.mikeschvedov.ifood.data.local_data.database.daos.FoodEntryDao
import com.mikeschvedov.ifood.data.local_data.database.entities.FoodEntry
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Mediator @Inject constructor(
    private val repository: Repository
) {


    // ------ Repository / Database ------ //

    suspend fun addNewEntry(foodEntry: FoodEntry) {
        repository.addNewEntry(foodEntry)
    }

    fun getFoodEntriesByDate(day: Int, month: Int, year:Int): Flow<List<FoodEntry>> {
        return repository.getFoodEntriesByDate(day, month, year)
    }

    suspend fun deleteEntryFromDB(foodEntry: FoodEntry) {
        repository.deleteEntryFromDB(foodEntry)
    }

    // ------ Calculations ------ //

    fun calculateTotalCalories(listOfEntries: List<FoodEntry>): Int {
        var sum = 0
        listOfEntries.forEach {
            sum += it.calories
        }
        return sum
    }
}