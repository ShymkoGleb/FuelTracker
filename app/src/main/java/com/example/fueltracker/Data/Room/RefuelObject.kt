package com.example.fueltracker.Data.Room

import android.icu.util.CurrencyAmount
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "refuel_object_table")
data class RefuelObject (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val mileage:String? = null,
    val fuelAmount: String? = null
)