package ComplementosInterfaz.Compartido.Inicio

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import ComplementosInterfaz.administrador.Gestionar.Gestionar
import ComplementosInterfaz.pasajero.PasajeroMapa
import com.example.rutas.R

class Loguearse : AppCompatActivity() {

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loguearse)

        val btnLogeo: Button = findViewById(R.id.btnLogeo)
        val etCorreo: EditText = findViewById(R.id.etCorreo)
        val etContrasena: EditText = findViewById(R.id.etContrasena)

        btnLogeo.setOnClickListener {
            val correo = etCorreo.text.toString().trim()
            val contrasena = etContrasena.text.toString()

            if (validarCampos(correo, contrasena)) {
                if (esCorreoValido(correo)) {
                    when {
                        correo == "admin@california.com" && contrasena == "admin" -> {
                            val intent = Intent(this, Gestionar::class.java)
                            startActivity(intent)
                        }
                        correo == "pasajero@gmail.com" && contrasena == "pasajero" -> {
                            val intent = Intent(this, PasajeroMapa::class.java)
                            startActivity(intent)
                        }
                        else -> {
                            Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, complete los campos correctamente", Toast.LENGTH_SHORT).show()
            }
        }

        val btnCrearcuenta: Button = findViewById(R.id.btnCrearcuenta)
        btnCrearcuenta.setOnClickListener {
            val intent = Intent(this, Registrarse::class.java)
            startActivity(intent)
        }

        var textorecuperacionContraseña = findViewById<TextView>(R.id.textorecuperacionContraseña)
        textorecuperacionContraseña.setOnClickListener {
            val intent = Intent(this, EnviarRecuperarion::class.java)
            startActivity(intent)
        }

    }

    private fun validarCampos(correo: String, contrasena: String): Boolean {
        return correo.isNotEmpty() && contrasena.isNotEmpty()
    }

    private fun esCorreoValido(correo: String): Boolean {
        return correo.equals("admin@california.com", ignoreCase = true) ||
                correo.matches(Regex("pasajero@gmail.com"))
    }


}