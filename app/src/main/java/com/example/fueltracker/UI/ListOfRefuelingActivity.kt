package com.example.fueltracker.UI

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fueltracker.Data.RefuelObjectViewModel
import com.example.fueltracker.R
import com.example.fueltracker.databinding.ActivityListOfRefuelingBinding

class ListOfRefuelingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListOfRefuelingBinding
    private lateinit var refuelObjectViewModel: RefuelObjectViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_refueling)
        setupBinding()
        val adapter = setupRecyclerViewAdapter()
        setupViewModel()
        //Logic
        setupListener()
        refuelObjectViewModel.readAllData.observe(this, Observer { refuelObject ->
            Log.d("Gleb", refuelObject.toString())
            adapter.setData(refuelObject)

        })
    }

    private fun setupViewModel() {
        refuelObjectViewModel = ViewModelProvider(this).get(RefuelObjectViewModel::class.java)
    }

    private fun setupRecyclerViewAdapter(): ListOfRefuelAdaptor {
        val adaptor = ListOfRefuelAdaptor(this)
        val recyclerView = binding.rvListOfRefueling
        recyclerView.adapter = adaptor
        recyclerView.layoutManager = LinearLayoutManager(this)

        return adaptor
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
