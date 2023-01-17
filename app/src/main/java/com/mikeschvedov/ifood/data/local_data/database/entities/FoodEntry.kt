package com.mikeschvedov.ifood.data.local_data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mikeschvedov.ifood.data.local_data.hardcoded.FoodCategory
import java.util.*

@Entity(tableName = "food_table")
data class FoodEntry(
    @PrimaryKey
    var foodId: String = UUID.randomUUID().toString(),
    val foodName: String,
    val calories: Int,
    val carbs: Int,
    val protein: Int,
    val fats: Int,
    val gramsOrUnit: String, //This has no use, it is only for extra info
    val imageName: String,
    val hour: Int,
    val day: Int,
    val month: Int,
    val year: Int,
    val itemCategory: FoodCategory

)