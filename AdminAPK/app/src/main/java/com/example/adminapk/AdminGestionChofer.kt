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

class AdminGestionChofer : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_gestion_chofer)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnModificarChofer = findViewById<Button>(R.id.btnModificarChofer)
        btnModificarChofer.setOnClickListener {
            val intent = Intent(this, AdminGestionChoferModificar::class.java)
            startActivity(intent)
        }

        val btnAgregarChofer = findViewById<Button>(R.id.btnAgregarChofer)
        btnAgregarChofer.setOnClickListener {
            val intent = Intent(this, AdminGestionChoferAgregar::class.java)
            startActivity(intent)
        }

        val btnEliminarChofer : Button =  findViewById(R.id.btnEliminarChofer)
        btnEliminarChofer.setOnClickListener {
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
            Toast.makeText(this, "Chofer eliminado", Toast.LENGTH_SHORT).show()
        }

        val btnEliminarCancelar: Button = view.findViewById(R.id.btnEliminarCancelar)
        btnEliminarCancelar.setOnClickListener {
            dialog.dismiss()
        }


        dialog = build.create()
        dialog.show()
    }
}