package com.mikeschvedov.ifood.data.local_data.database.daos

import androidx.room.*
import com.mikeschvedov.ifood.data.local_data.database.entities.FoodEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodEntryDao {

    @Query("SELECT * FROM food_table WHERE" +
            " day LIKE '%' || :day || '%' AND" +
            " month LIKE '%' || :month || '%' AND" +
            " year LIKE '%' || :year || '%'" +
            "ORDER BY foodId ASC")
    fun getFoodEntriesByDate(day: Int, month: Int, year: Int): Flow<List<FoodEntry>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewEntry(food: FoodEntry)

    @Delete
    suspend fun deleteEntry(food: FoodEntry)

}