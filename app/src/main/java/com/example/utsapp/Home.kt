package com.example.utsapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val frameLayout = findViewById<FrameLayout>(R.id.fragment_container)
        val seeMenuButton = findViewById<Button>(R.id.menusButton)
        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)

        seeMenuButton.setOnClickListener {
            frameLayout.visibility = View.VISIBLE
            frameLayout.setBackgroundColor(Color.parseColor("#FFFFFF"))
            recyclerView.setBackgroundColor(Color.parseColor("#FFFFFF"))
            recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)

            val fabOrder = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fabOrder)
            fabOrder.setOnClickListener{
                val intent = Intent(this, Details::class.java)
                startActivity(intent)
            }

            val data = ArrayList<ItemsViewModel>(
                listOf(
                    ItemsViewModel(R.drawable.pizza2, "Pepperoni Pizza", "Cocok bagi anda yang ingin merasakan pizza original dengan taburan keju dan daging asap yang lezat"),
                    ItemsViewModel(R.drawable.spaghetti, "Spaghetti", "Cocok bagi anda yang ingin merasakan spaghetti original dengan bumbu yang oriental"),
                    ItemsViewModel(R.drawable.burger, "Burger", "Cocok bagi anda yang ingin merasakan kelembutan burger berlapiskan keju, sayuran dan daging yang tebal"),
                    ItemsViewModel(R.drawable.steak, "Steak", "Cocok bagi anda yang ingin merasakan lezatnya daging steak dipadukan dengan kentang yang lezat"),
                )
            )

            val adapter = CustomAdapter(data)

            recyclerView.adapter = adapter
        }

    }
}