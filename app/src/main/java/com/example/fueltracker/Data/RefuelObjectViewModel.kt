package com.example.fueltracker.Data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.fueltracker.Data.Repository.RefuelObjectRepository
import com.example.fueltracker.Data.Room.RefuelObject
import com.example.fueltracker.Data.Room.RefuelObjectDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RefuelObjectViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllData: LiveData<List<RefuelObject>>
    private val repository: RefuelObjectRepository

    init {
        val refuelObjectDao = RefuelObjectDB.getDatabase(application).refuelObjectDao()
        repository = RefuelObjectRepository(refuelObjectDao)
        readAllData = repository.readAllData
    }

    fun addRefuelObject(refuelObject: RefuelObject) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRefuelObject(refuelObject)
        }
    }


}