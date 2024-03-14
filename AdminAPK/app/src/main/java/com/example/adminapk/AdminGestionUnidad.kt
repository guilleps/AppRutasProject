package com.example.adminapk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class AdminGestionUnidad : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_gestion_unidad)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnModificarUnidad = findViewById<Button>(R.id.btnModificarUnidad)
        btnModificarUnidad.setOnClickListener {
            val intent = Intent(this, AdminGestionUnidadModificar::class.java)
            startActivity(intent)
        }

        val btnAgregarUnidad = findViewById<Button>(R.id.btnAgregarUnidad)
        btnAgregarUnidad.setOnClickListener {
            val intent = Intent(this, AdminGestionUnidadAgregar::class.java)
            startActivity(intent)
        }

        val btnEliminarUnidad : Button =  findViewById(R.id.btnEliminarUnidad)
        btnEliminarUnidad.setOnClickListener {
            showAlertDialog()
        }

    }

    @SuppressLint("MissingInflatedId")
    private fun showAlertDialog() {
        val build = AlertDialog.Builder(this, R.style.ThemeCustomDialog)
        val view = layoutInflater.inflate(R.layout.custom_dialog_eliminar, null)
        build.setView(view)

        val btnEliminarConfirmar: Button = view.findViewById(R.id.btnEliminarConfirmar)
        btnEliminarConfirmar.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Unidad eliminada", Toast.LENGTH_SHORT).show()
        }

        val btnEliminarCancelar: Button = view.findViewById(R.id.btnEliminarCancelar)
        btnEliminarCancelar.setOnClickListener {
            dialog.dismiss()
        }


        dialog = build.create()
        dialog.show()
    }

}