package com.mikeschvedov.ifood.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikeschvedov.ifood.data.local_data.database.Repository
import com.mikeschvedov.ifood.data.local_data.database.entities.FoodEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _isListEmpty = MutableLiveData<Boolean>()
    val isListEmpty: LiveData<Boolean> get() = _isListEmpty

    private var adapter = HomeRecyclerAdapter(){
        _isListEmpty.postValue(it)
    }

    fun getRecyclerAdapter(): HomeRecyclerAdapter {
        return adapter
    }

    fun addNewEntryToDB(foodEntry: FoodEntry){
        viewModelScope.launch {
            repository.addNewEntry(foodEntry)
        }
    }

    fun getAllEntriesByDate(day: Int, month: Int, year: Int){
        viewModelScope.launch {
            repository.getFoodEntriesByDate(day, month, year).collect{ listOfEntries ->
                adapter.setNewData(listOfEntries)
            }
        }
    }
}