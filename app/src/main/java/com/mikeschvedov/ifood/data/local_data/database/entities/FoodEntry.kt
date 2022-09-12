package com.mikeschvedov.ifood.data.local_data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "food_table")
data class FoodEntry(
    @PrimaryKey
    var foodId: String = UUID.randomUUID().toString(),
    val foodName: String,
    val calories: Int,
    val image: Int,
    val hour: Int,
    val day: Int,
    val month: Int,
    val year: Int

)