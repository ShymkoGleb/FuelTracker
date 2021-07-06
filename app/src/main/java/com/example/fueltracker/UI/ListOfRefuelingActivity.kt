package com.example.fueltracker.UI

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fueltracker.R
import com.example.fueltracker.databinding.ActivityListOfRefuelingBinding

class ListOfRefuelingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListOfRefuelingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_refueling)
        setupBinding()
        setupListener()
    }

    private fun setupListener() {
        binding.bntMainPage.setOnClickListener {
            MainActivity.start(this)
        }
    }

    private fun setupBinding() {
        binding = ActivityListOfRefuelingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ListOfRefuelingActivity::class.java)
            context.startActivity(intent)
        }
    }
}
