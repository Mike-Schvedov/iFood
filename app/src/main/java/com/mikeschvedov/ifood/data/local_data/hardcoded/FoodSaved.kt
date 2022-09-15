package com.mikeschvedov.ifood.data.local_data.hardcoded

data class FoodSaved(
    var name: String,
    var calPer100gr: Int,
    var image: Int,
    var asUnit: Boolean,
    var caloriesPerUnit: Int,
    var category: FoodCategory

){
    // Overriding so we can show only the name in the listview
    override fun toString() = this.name
}