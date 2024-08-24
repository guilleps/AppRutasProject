package com.example.adminapk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton

class AdminInicio : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_inicio)

        val btnStart = findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener {
            val intent = Intent(this, AdminLogeo::class.java)
            startActivity(intent)
        }
        
    }
}