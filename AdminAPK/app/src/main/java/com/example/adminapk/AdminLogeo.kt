package com.example.adminapk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class AdminLogeo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_logeo)

        val btnLogeo = findViewById<AppCompatButton>(R.id.btnLogeo)
        val etCorreo = findViewById<AppCompatEditText>(R.id.etCorreo)
        val etContraseña = findViewById<AppCompatEditText>(R.id.etContraseña)

        btnLogeo.setOnClickListener {
            val correo = etCorreo.text.toString()
            val contraseña = etContraseña.text.toString()

            if (correo== "administrador" && contraseña == "administrador") {
                val intent = Intent(this, AdminGestion::class.java)
                startActivity(intent)
                Toast.makeText(this, "Bienvenido, Administrador", Toast.LENGTH_SHORT).show()
            } else {
            Toast.makeText(this, "Bienvenido, Pasajero", Toast.LENGTH_SHORT).show()
                // Inicio de sesión inválido, mostrar un mensaje de error
                // o realizar alguna acción adicional si es necesario
            }
        }
    }
}