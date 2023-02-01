package com.mikeschvedov.ifood.data.local_data.hardcoded

data class FoodSaved(
    var name: String,
    var calPer100gr: Int,
    var carbPer100gr: Int? = null,
    var netCarbPer100gr: Int? = null,
    var proteinPer100gr: Int? = null,
    var fatPer100gr: Int? = null,
    var imageID: Int,
    var asUnit: Boolean,
    var caloriesPerUnit: Int,
    var carbPerUnit: Int? = null,
    var netCarbPerUnit: Int? = null,
    var proteinPerUnit: Int? = null,
    var fatPerUnit: Int? = null,
    var category: FoodCategory,
){
    // Overriding so we can show only the name in the listview
    override fun toString() = this.name
}