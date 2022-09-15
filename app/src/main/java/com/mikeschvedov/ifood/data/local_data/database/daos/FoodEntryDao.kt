package com.mikeschvedov.ifood.data.local_data.database.daos

import androidx.room.*
import com.mikeschvedov.ifood.data.local_data.database.entities.FoodEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodEntryDao {

// This is an example if we want the day to contain any character inside the value
// " day LIKE '%' || :day || '%' AND" +

    @Query("SELECT * FROM food_table WHERE" +
            " day = :day AND" + // If day contains exactly this value
            " month = :month AND" +
            " year = :year " +
            "ORDER BY foodId ASC")
    fun getFoodEntriesByDate(day: Int, month: Int, year: Int): Flow<List<FoodEntry>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewEntry(food: FoodEntry)

    @Delete
    suspend fun deleteEntry(food: FoodEntry)

}