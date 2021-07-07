package com.example.fueltracker.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fueltracker.Data.Room.RefuelObject
import com.example.fueltracker.ListOfRefuelObjectsDirections
import com.example.fueltracker.R
import kotlinx.android.synthetic.main.item_rv_list_of_refueling.view.*

class ListOfRefuelAdaptor : RecyclerView.Adapter<ListOfRefuelAdaptor.MyViewHolder>() {

    private var refuelObjectList = emptyList<RefuelObject>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rv_list_of_refueling, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = refuelObjectList[position]
        holder.itemView.tvFuelAmount.text = currentItem.fuelAmount.toString()
        holder.itemView.tvMileage.text = currentItem.mileage.toString()
        holder.itemView.item_rv_list_of_refueling.setOnClickListener {
            val action = ListOfRefuelObjectsDirections.actionListOfRefuelObjectsToStartFragment()
        }
    }

    override fun getItemCount(): Int {
        return refuelObjectList.size
    }

    fun setData(refuelObject: List<RefuelObject>) {
        this.refuelObjectList = refuelObject
        notifyDataSetChanged()
    }
}