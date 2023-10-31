package com.example.utsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)

        val orderNow = findViewById<Button>(R.id.orderNowButton)
        val back = findViewById<Button>(R.id.backButton)

        orderNow.setOnClickListener{
            val intent = Intent(this, Order::class.java)
            startActivity(intent)
        }

        back.setOnClickListener{
            onBackPressed()
        }
    }
}