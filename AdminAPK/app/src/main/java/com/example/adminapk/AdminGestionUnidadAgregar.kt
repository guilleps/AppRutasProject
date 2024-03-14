package com.example.adminapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AdminGestionUnidadAgregar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_gestion_unidad_agregar)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }
    }
}