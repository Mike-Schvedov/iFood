package com.mikeschvedov.ifood.ui.add_entry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikeschvedov.ifood.data.local_data.database.Repository
import com.mikeschvedov.ifood.data.local_data.database.entities.FoodEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEntryViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    fun addNewEntryToDB(foodEntry: FoodEntry){
        viewModelScope.launch {
            repository.addNewEntry(foodEntry)
        }
    }
}