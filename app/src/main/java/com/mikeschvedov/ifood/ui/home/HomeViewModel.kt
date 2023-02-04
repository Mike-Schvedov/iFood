package com.mikeschvedov.ifood.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikeschvedov.ifood.data.Mediator
import com.mikeschvedov.ifood.data.local_data.database.Repository
import com.mikeschvedov.ifood.data.local_data.database.entities.FoodEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.logging.Logger
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mediator: Mediator
) : ViewModel() {

    // Used to notify the fragment to display the "empty list" message
    private val _isListEmpty = MutableLiveData<Boolean>()
    val isListEmpty: LiveData<Boolean> get() = _isListEmpty

    // The sum of all calories from a specific day
    private val _totalDailyCalories = MutableLiveData<Int>()
    val totalDailyCalories: LiveData<Int> get() = _totalDailyCalories

    // The sum of all carbs from a specific day
    private val _totalDailyCarbs = MutableLiveData<String>()
    val totalDailyCarbs: LiveData<String> get() = _totalDailyCarbs

    // The sum of all neto carbs from a specific day
    private val _totalDailyNetoCarbs = MutableLiveData<String>()
    val totalDailyNetoCarbs: LiveData<String> get() = _totalDailyNetoCarbs

    // The sum of all protein from a specific day
    private val _totalDailyProtein = MutableLiveData<String>()
    val totalDailyProtein: LiveData<String> get() = _totalDailyProtein

    // The sum of all fats from a specific day
    private val _totalDailyFats = MutableLiveData<String>()
    val totalDailyFats: LiveData<String> get() = _totalDailyFats

    // We first send the item to the fragment to display the alert before deletion
    private val _itemToDelete = MutableLiveData<FoodEntry>()
    val itemToDelete: LiveData<FoodEntry> get() = _itemToDelete

    private var adapter = HomeRecyclerAdapter(
        { itemClickedCallback ->
            _itemToDelete.postValue(itemClickedCallback)
        },
        { isListEmptyCallback ->
            _isListEmpty.postValue(isListEmptyCallback)
        })

    fun deleteItem(foodEntry: FoodEntry) {
        viewModelScope.launch {
            mediator.deleteEntryFromDB(foodEntry)
        }
    }

    fun getRecyclerAdapter(): HomeRecyclerAdapter {
        return adapter
    }

    fun getAllEntriesByDate(day: Int, month: Int, year: Int) {
        viewModelScope.launch {
            mediator.getFoodEntriesByDate(day, month, year).collect { listOfEntries ->
                adapter.setNewData(listOfEntries.sortedBy { it.hour })

                // Calculate total daily calories and post to live data
                val totalCalories = mediator.calculateTotalCalories(listOfEntries)
                _totalDailyCalories.postValue(totalCalories)

                // Calculate total daily carbs and post to live data
                val totalCarbs = mediator.calculateTotalCarbs(listOfEntries)
                val carbsPercent = calculateMacroPercent(totalCalories, totalCarbs, 4)
                val rawCarbsString = "פחמימה - ${totalCarbs} גרם (${carbsPercent}%)"
                _totalDailyCarbs.postValue(rawCarbsString)

                // Calculate total daily carbs and post to live data
                val totalNetoCarbs = mediator.calculateTotalNetoCarbs(listOfEntries)
                val rawNetCarbsString = "פחמימה נטו - ${totalNetoCarbs} גרם "
                _totalDailyNetoCarbs.postValue(rawNetCarbsString)

                // Calculate total daily protein and post to live data
                val totalProtein = mediator.calculateTotalProtein(listOfEntries)
                val proteinPercent = calculateMacroPercent(totalCalories, totalProtein, 4)
                val rawProteinString = "חלבון - ${totalProtein} גרם (${proteinPercent}%)"
                _totalDailyProtein.postValue(rawProteinString)

                // Calculate total daily fats and post to live data
                val totalFats = mediator.calculateTotalFats(listOfEntries)
                val fatsPercent = calculateMacroPercent(totalCalories, totalFats, 9)
                val rawFatsString = "שומן - ${totalFats} גרם (${fatsPercent}%)"
                _totalDailyFats.postValue(rawFatsString)
            }
        }
    }

    private fun calculateMacroPercent(
        totalCalories: Int,
        totalGrams: Int,
        caloriesPerGram: Int
    ): Any {
        if (totalCalories == 0) {
            return 0
        } else {
            val caloriesFromMacro = totalGrams.toDouble() * caloriesPerGram
            println("caloriesFromMacro - $caloriesFromMacro")
            val sumDouble: Double = caloriesFromMacro / totalCalories.toDouble()
            println("sumDouble - $sumDouble")
            val finalSum: Double = sumDouble * 100.0
            println("finalSum - $finalSum")
            println("finalSum to int - ${finalSum.roundToInt()}")
            return finalSum.roundToInt()
        }
    }
}