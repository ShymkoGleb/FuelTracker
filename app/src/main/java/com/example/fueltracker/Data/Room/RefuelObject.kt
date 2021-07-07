package com.example.fueltracker.Data.Room

import android.icu.util.CurrencyAmount
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*


@Parcelize
@Entity(tableName = "refuel_object_table")
data class RefuelObject (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val mileage:Int? = null,
    val fuelAmount: Int? = null,
):Parcelable