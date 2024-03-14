package com.example.adminapk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class AdminGestionComentario : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_gestion_comentario)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnComentar: View = findViewById(R.id.btnComentar)
        btnComentar.setOnClickListener {
            val intent = Intent(this, AdminGestionComentarioAgregar::class.java)
            startActivity(intent)
        }

    }
}