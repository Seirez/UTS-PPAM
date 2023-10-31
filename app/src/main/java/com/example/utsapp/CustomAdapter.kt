package com.example.utsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val foodList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val foodImage: ImageView = itemView.findViewById(R.id.Image)
        val foodName: TextView = itemView.findViewById(R.id.Name)
        val foodDescription: TextView = itemView.findViewById(R.id.Desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodItem = foodList[position]

        holder.foodImage.setImageResource(foodItem.image)
        holder.foodName.text = foodItem.name
        holder.foodDescription.text = foodItem.desc
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}