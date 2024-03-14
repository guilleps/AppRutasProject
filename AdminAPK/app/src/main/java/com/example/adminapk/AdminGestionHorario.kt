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

class AdminGestionHorario : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_gestion_horario)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnModificar = findViewById<AppCompatButton>(R.id.btnModificar)
        btnModificar.setOnClickListener {
            val intent = Intent(this, AdminGestionHorarioModificar::class.java)
            startActivity(intent)
        }

        val btnAgregarhor = findViewById<AppCompatButton>(R.id.btnAgregarhor)
        btnAgregarhor.setOnClickListener {
            val intent = Intent(this, AdminGestionHorarioAgregar::class.java)
            startActivity(intent)
        }

        val btnEliminarHorario : Button =  findViewById(R.id.btnEliminarHorario)
        btnEliminarHorario.setOnClickListener {
            showAlertDialog()
            finishActivity(R.layout.custom_dialog_eliminar)
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
            Toast.makeText(this, "Horario eliminado", Toast.LENGTH_SHORT).show()
        }

        val btnEliminarCancelar: Button = view.findViewById(R.id.btnEliminarCancelar)
        btnEliminarCancelar.setOnClickListener {
            dialog.dismiss()
        }

        dialog = build.create()
        dialog.show()
    }

}