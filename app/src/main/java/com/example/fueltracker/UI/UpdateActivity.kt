package com.example.fueltracker.UI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.fueltracker.Data.RefuelObjectViewModel
import com.example.fueltracker.Data.Room.RefuelObject
import com.example.fueltracker.R
import com.example.fueltracker.databinding.ActivityMainBinding
import com.example.fueltracker.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var refuelObjectViewModel: RefuelObjectViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        setupBinding()
        setupViewModel()
        //
        setupListener()
        getIncomingIntent()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.delete_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val menyItemWasSelected = item.itemId
        if (menyItemWasSelected == R.id.menuDelete) {
            showToast("DELETE" + R.id.menuDelete.toString())
            deleteAllUser()
        }
        if (menyItemWasSelected == R.id.menuHello) {
            showToast("HELLO" + R.id.menuHello.javaClass.fields.toString())
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllUser() {
        val builder = AlertDialog.Builder(this)
        builder.setPositiveButton("True") { _, _ -> refuelObjectViewModel.deleteALLRefuelObject() }
        builder.setNegativeButton("False") { _, _ -> showToast("Why not?") }
        builder.setTitle("HELLO, May I delete?")
            .create().show()
    }


    private fun setupBinding() {
        binding = ActivityUpdateBinding.inflate(layoutInflater)
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

        binding.bntUpdateValue.setOnClickListener {
            if (binding.etFuelAmount.text.isNotEmpty() && binding.etCurrentMiles.text.isNotEmpty()) {
                getNewData()
                showToast("Information is addet to database")
            } else {
                showToast("Fill the fields")
            }
        }

        binding.bntMainPage.setOnClickListener {
            MainActivity.start(this)
        }
    }


    private fun getNewData() {
        val currentMiles = binding.etCurrentMiles.text.toString().toInt()
        val fuelAmount = binding.etFuelAmount.text.toString().toInt()
        val refuelObject = RefuelObject(0, currentMiles, fuelAmount)
        Log.d("Gleb", "RefuelObjectViewModel ->getNewData()" + refuelObject.toString())
        refuelObjectViewModel.addRefuelObject(refuelObject)
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, UpdateActivity::class.java)
            context.startActivity(intent)
        }
    }

    private fun getIncomingIntent() {
        if (intent.hasExtra("refuelObject")) {
            val refuelObject = intent.getParcelableExtra<RefuelObject>("refuelObject")
            makeLog("refuelObject" + "${refuelObject.toString()}")
        }
    }

    private fun makeLog(message: String) {
        Log.d("Gleb", message)
    }
}