package com.example.adminapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.adminapk.databinding.ActivityComentarBinding

class AdminGestionComentarioAgregar : AppCompatActivity() {

    private lateinit var binding:ActivityComentarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComentarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val routes = resources.getStringArray(R.array.route_bus)
        val adapter = ArrayAdapter(
            this,
            R.layout.list_item,
            routes
        )

        with(binding.autoCompleteTextView) {
            setAdapter(adapter)
        }

        val btnPublicar : Button = findViewById(R.id.btnPublicar)
        btnPublicar.setOnClickListener {
            finish()
            Toast.makeText(this, "Comentario publicado", Toast.LENGTH_SHORT).show()
        }

    }
}