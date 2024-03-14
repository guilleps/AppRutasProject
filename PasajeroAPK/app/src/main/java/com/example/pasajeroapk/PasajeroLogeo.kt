package com.example.pasajeroapk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class PasajeroLogeo : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pasajero_logeo)

        val btnCreacuenta = findViewById<AppCompatButton>(R.id.btnCrearcuenta)
        btnCreacuenta.setOnClickListener {
            val intent = Intent(this, PasajeroRegistro::class.java)
            startActivity(intent)
        }


        val btnLogeo = findViewById<AppCompatButton>(R.id.btnLogeo)
        val etCorreo = findViewById<AppCompatEditText>(R.id.etCorreo)
        val etContraseña = findViewById<AppCompatEditText>(R.id.etContraseña)

        btnLogeo.setOnClickListener {
            val correo = etCorreo.text.toString()
            val contraseña = etContraseña.text.toString()

            if (correo.isNotEmpty() && contraseña.isNotEmpty()) {
                val intent = Intent(this, PasajeroMapa::class.java)
                startActivity(intent)
            }
        }

    }
}