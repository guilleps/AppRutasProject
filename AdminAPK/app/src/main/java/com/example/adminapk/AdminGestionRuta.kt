package com.example.adminapk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton

class AdminGestionRuta : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_gestion_ruta)

        val btnAtras: ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnModificarRuta = findViewById<AppCompatButton>(R.id.btnModificarRuta)
        btnModificarRuta.setOnClickListener {
            val intent = Intent(this, AdminGestionRutaModificar::class.java)
            startActivity(intent)
        }

        val btnNuevaRuta = findViewById<AppCompatButton>(R.id.btnNuevaRuta)
        btnNuevaRuta.setOnClickListener {
            val intent = Intent(this, AdminGestionRutaAgregar::class.java)
            startActivity(intent)
        }

        val btnEliminarRuta: Button = findViewById(R.id.btnEliminarRuta)
        btnEliminarRuta.setOnClickListener {
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
            Toast.makeText(this, "Ruta eliminada", Toast.LENGTH_SHORT).show()
        }

        val btnEliminarCancelar: Button = view.findViewById(R.id.btnEliminarCancelar)
        btnEliminarCancelar.setOnClickListener {
            dialog.dismiss()
        }

        dialog = build.create()
        dialog.show()
    }

}