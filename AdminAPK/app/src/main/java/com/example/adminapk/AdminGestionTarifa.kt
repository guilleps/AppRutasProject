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

class AdminGestionTarifa : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_gestion_tarifa)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnModificar = findViewById<AppCompatButton>(R.id.btnModificar)
        btnModificar.setOnClickListener {
            val intent = Intent(this, AdminGestionTarifaModificar::class.java)
            startActivity(intent)
        }

        val btnAgregartar = findViewById<AppCompatButton>(R.id.btnAgregartar)
        btnAgregartar.setOnClickListener {
            val intent = Intent(this, AdminGestionTarifaAgregar::class.java)
            startActivity(intent)
        }

        val btnEliminarTarifa : Button =  findViewById(R.id.btnEliminarTarifa)
        btnEliminarTarifa.setOnClickListener {
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
            Toast.makeText(this, "Tarifa eliminada", Toast.LENGTH_SHORT).show()
        }

        val btnEliminarCancelar: Button = view.findViewById(R.id.btnEliminarCancelar)
        btnEliminarCancelar.setOnClickListener {
            dialog.dismiss()
        }

        dialog = build.create()
        dialog.show()
    }

}