package com.example.adminapk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class AdminGestionHorarioModificar : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_gestion_horario_modificar)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnGuardarHorarioModificado:Button = findViewById(R.id.btnGuardarHorarioModificado)
        btnGuardarHorarioModificado.setOnClickListener {
            showAlertDialog()
        }
    }

    @SuppressLint("MissingInflatedId")
    private fun showAlertDialog() {
        val build = AlertDialog.Builder(this, R.style.ThemeCustomDialog)
        val view = layoutInflater.inflate(R.layout.custom_dialog_modificar, null)
        build.setView(view)

        val btnModificarConfirmar: Button = view.findViewById(R.id.btnModificarConfirmar)
        btnModificarConfirmar.setOnClickListener {
            finish()
        }

        dialog = build.create()
        dialog.show()
    }
}