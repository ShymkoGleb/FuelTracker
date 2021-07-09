package com.example.fueltracker.Data.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.fueltracker.Data.Room.RefuelObject
import com.example.fueltracker.Data.Room.RefuelObjectDao

class RefuelObjectRepository(private val refuelObjectDao: RefuelObjectDao) {

    val readAllData: LiveData<List<RefuelObject>> = refuelObjectDao.readAllRefuelObjects()

    suspend fun addRefuelObject(refuelObject: RefuelObject){
        Log.d("Gleb","RefuelObjectRepository ->addRefuelObject()")
        refuelObjectDao.addRefuelObject(refuelObject)
    }

    suspend fun deleteRefuelObject(refuelObject: RefuelObject){
        Log.d("Gleb","RefuelObjectRepository ->deleteUser()")
        refuelObjectDao.deleteRefuelObject(refuelObject)
    }

    suspend fun deleteAllRefuelObjects(){
        Log.d("Gleb","RefuelObjectRepository ->deleteAllRefuelObjects()")
        refuelObjectDao.deleteAllRefuelObject()
    }

}