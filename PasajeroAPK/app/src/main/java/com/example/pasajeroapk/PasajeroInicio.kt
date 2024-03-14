package com.example.pasajeroapk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class PasajeroInicio : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pasajero_inicio)
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)

        btnStart.setOnClickListener {
            val intent = Intent(this, PasajeroLogeo::class.java)
            startActivity(intent)
        }

    }
}