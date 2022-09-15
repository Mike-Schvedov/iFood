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
import javax.inject.Inject

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

    // We first send the item to the fragment to display the alert before deletion
    private val _itemToDelete = MutableLiveData<FoodEntry>()
    val itemToDelete: LiveData<FoodEntry> get() = _itemToDelete

    private var adapter = HomeRecyclerAdapter(
        { itemClickedCallback ->
            _itemToDelete.postValue(itemClickedCallback)
        },
        { isListEmptyCallback->
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

    fun getAllEntriesByDate(day: Int, month: Int, year: Int){
        viewModelScope.launch {
            mediator.getFoodEntriesByDate(day, month, year).collect{ listOfEntries ->
                adapter.setNewData(listOfEntries)

                // Calculate total daily calories and post to live data
                val totalCalories = mediator.calculateTotalCalories(listOfEntries)
                _totalDailyCalories.postValue(totalCalories)
            }
        }
    }
}