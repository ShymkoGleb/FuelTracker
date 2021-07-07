package com.example.fueltracker.UI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.fueltracker.Data.RefuelObjectViewModel
import com.example.fueltracker.Data.Room.RefuelObject
import com.example.fueltracker.R
import com.example.fueltracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var refuelObjectViewModel: RefuelObjectViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBinding()
        setupViewModel()
        //
        setupUi()
        setupListener()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


    private fun setupViewModel() {
        refuelObjectViewModel = ViewModelProvider(this).get(RefuelObjectViewModel::class.java)
    }

    private fun setupListener() {
        binding.bntListOfRefueling.setOnClickListener {
            ListOfRefuelingActivity.start(this)
        }

        binding.bntAddNewValue.setOnClickListener {
            if (binding.etFuelAmount.text.isNotEmpty() && binding.etCurrentMiles.text.isNotEmpty()) {
                getNewData()
                showToast("Information is addet to database")
            } else {
                showToast("Fill the fields")
            }
        }
    }

    private fun setupUi() {
    //binding.tvAvarageFuelAmount.text = refuelObjectViewModel.currentMile.toString()
    }


    private fun getNewData() {
        val currentMiles = binding.etCurrentMiles.text.toString().toInt()
        val fuelAmount = binding.etFuelAmount.text.toString().toInt()
        val refuelObject = RefuelObject(0,currentMiles,fuelAmount)
        Log.d("Gleb","RefuelObjectViewModel ->getNewData()" + refuelObject.toString())
        refuelObjectViewModel.addRefuelObject(refuelObject)
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
}