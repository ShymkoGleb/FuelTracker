package com.example.fueltracker.Data.Repository

import androidx.lifecycle.LiveData
import com.example.fueltracker.Data.Room.RefuelObject
import com.example.fueltracker.Data.Room.RefuelObjectDao

class RefuelObjectRepository(private val refuelObjectDao: RefuelObjectDao) {

    val readAllData: LiveData<List<RefuelObject>> = refuelObjectDao.readAllRefuelObjects()

    suspend fun addRefuelObject(refuelObject: RefuelObject){
        refuelObjectDao.addRefuelObject(refuelObject)
    }

}