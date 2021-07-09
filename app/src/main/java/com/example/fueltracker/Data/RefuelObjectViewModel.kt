package com.example.fueltracker.Data

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.fueltracker.Data.Repository.RefuelObjectRepository
import com.example.fueltracker.Data.Room.RefuelObject
import com.example.fueltracker.Data.Room.RefuelObjectDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RefuelObjectViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<RefuelObject>>
    private val repository: RefuelObjectRepository


    init {
        val refuelObjectDao = RefuelObjectDB.getDatabase(application).refuelObjectDao()
        repository = RefuelObjectRepository(refuelObjectDao)
        readAllData = repository.readAllData
    }

    fun addRefuelObject(refuelObject: RefuelObject) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Gleb", "RefuelObjectViewModel ->addRefuelObject()")
            repository.addRefuelObject(refuelObject)
        }
    }

    fun deleteRefuelObject(refuelObject: RefuelObject) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Gleb", "RefuelObjectViewModel ->deleteRefuelObject()")
            repository.deleteRefuelObject(refuelObject)
        }
    }

    fun deleteALLRefuelObject() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Gleb", "RefuelObjectViewModel ->deleteALLRefuelObject()")
            repository.deleteAllRefuelObjects()
        }
    }

    fun calcAvaregeFuel(owner: LifecycleOwner): Int {
        var avarageFuelAmount = 0
        var totalFuelAmount = 0
        readAllData.observe(owner) { listOfRefuelObject ->
            listOfRefuelObject.forEach {
                totalFuelAmount += it.fuelAmount.toString().toInt()
                makeLog("$totalFuelAmount")
            }
            val asda = totalFuelAmount / listOfRefuelObject.size
            makeLog("2 = $avarageFuelAmount")
        }
        return 0
    }


    private fun makeLog(message: String) {
        Log.d("Gleb", message)
    }
}