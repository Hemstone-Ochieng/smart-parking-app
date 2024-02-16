package com.devkaybee.smartparking.ui.admin.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devkaybee.smartparking.R
import com.devkaybee.smartparking.data.AddSlots
import com.devkaybee.smartparking.ui.driver.dashboard.BookingActivity


class ParkListAdapter(var parkingList: ArrayList<AddSlots>): RecyclerView.Adapter<ParkListAdapter.ParkListViewHolder>(){

    inner class  ParkListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var parkTitle: TextView = itemView.findViewById(R.id.tvTitle)
        var parkLocation: TextView = itemView.findViewById(R.id.tvParkLocation)
        var parkedVehicles: TextView = itemView.findViewById(R.id.tvParkedVehicleNumbers)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.admin_itemparkslots, parent,false)
        return  ParkListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParkListViewHolder, position: Int) {

        holder.apply {
            parkTitle.text = parkingList[position].parkName
            parkedVehicles.text = parkingList[position].maxCapacity
            parkLocation.text = parkingList[position].location

        }




        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, BookingActivity::class.java)
            intent.putExtra("Park", itemCount)
            holder.itemView.context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return  parkingList.size
    }
}