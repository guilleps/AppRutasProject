package com.example.adminapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView

class AdminGestion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_gestion)

        val btnHorarios: CardView = findViewById(R.id.btnHorarios)
        btnHorarios.setOnClickListener {
            val intent = Intent(this, AdminGestionHorario::class.java)
            startActivity(intent)
        }

        val btnTarifas: CardView = findViewById(R.id.btnTarifas)
        btnTarifas.setOnClickListener {
            val intent = Intent(this, AdminGestionTarifa::class.java)
            startActivity(intent)
        }

        val btnRutas: CardView = findViewById(R.id.btnRutas)
        btnRutas.setOnClickListener {
            val intent = Intent(this, AdminGestionRuta::class.java)
            startActivity(intent)
        }

        val btnComentarios: CardView = findViewById(R.id.btnComentarios)
        btnComentarios.setOnClickListener {
            val intent = Intent(this, AdminGestionComentario::class.java)
            startActivity(intent)
        }

        val btnConductores: CardView = findViewById(R.id.btnConductores)
        btnConductores.setOnClickListener {
            val intent = Intent(this, AdminGestionChofer::class.java)
            startActivity(intent)
        }

        val btnUnidades: CardView = findViewById(R.id.btnUnidades)
        btnUnidades.setOnClickListener {
            val intent = Intent(this, AdminGestionUnidad::class.java)
            startActivity(intent)
        }

    }
}