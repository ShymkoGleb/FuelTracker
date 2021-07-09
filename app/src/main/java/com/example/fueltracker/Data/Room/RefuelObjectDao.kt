package com.example.fueltracker.Data.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RefuelObjectDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRefuelObject(refuelObject: RefuelObject)

    @Query("SELECT*FROM refuel_object_table ORDER BY id ASC")
    fun readAllRefuelObjects(): LiveData<List<RefuelObject>>

    @Delete
    suspend fun deleteRefuelObject(refuelObject: RefuelObject)

    @Query("DELETE FROM refuel_object_table")
    suspend fun deleteAllRefuelObject()



}