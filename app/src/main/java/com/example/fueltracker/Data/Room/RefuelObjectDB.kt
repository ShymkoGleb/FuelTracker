package com.example.fueltracker.Data.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [RefuelObject::class], version = 1, exportSchema = false)
abstract class RefuelObjectDB : RoomDatabase() {

    abstract fun refuelObjectDao(): RefuelObjectDao

    companion object {
        @Volatile
        private var INSTANCE: RefuelObjectDB? = null

        fun getDatabase(context: Context): RefuelObjectDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RefuelObjectDB::class.java,
                    "refuel_object_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }

}