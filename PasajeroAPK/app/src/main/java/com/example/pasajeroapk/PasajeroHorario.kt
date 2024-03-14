package com.example.pasajeroapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class PasajeroHorario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pasajero_horario)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

    }
}