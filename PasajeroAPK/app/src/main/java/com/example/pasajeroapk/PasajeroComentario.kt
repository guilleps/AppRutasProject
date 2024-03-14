package com.example.pasajeroapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.example.pasajeroapk.databinding.ActivityPasajeroComentarioBinding

class PasajeroComentario : AppCompatActivity() {

    private lateinit var binding: ActivityPasajeroComentarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasajeroComentarioBinding.inflate(layoutInflater)
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
    }
}