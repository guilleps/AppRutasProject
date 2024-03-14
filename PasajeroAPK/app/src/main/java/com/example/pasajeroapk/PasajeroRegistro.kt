package com.example.pasajeroapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class PasajeroRegistro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pasajero_registro)

        val btnCrearcuentaRegistro = findViewById<AppCompatButton>(R.id.btnCrearcuentaRegistro)

        btnCrearcuentaRegistro.setOnClickListener {
            val intent = Intent(this, PasajeroMapa::class.java)
            startActivity(intent)
        }

    }
}