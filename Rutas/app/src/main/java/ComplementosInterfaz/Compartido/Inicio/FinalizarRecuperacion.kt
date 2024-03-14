package ComplementosInterfaz.Compartido.Inicio

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.rutas.R

class FinalizarRecuperacion : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.finalizar_recuperacion)

        val btnGuardarCambioContrasena: Button = findViewById(R.id.btnGuardarCambioContrasena)
        val etNuevaContrasena: EditText = findViewById(R.id.etNuevaContrasena)
        val etValidaNuevaContrasena: EditText = findViewById(R.id.etValidaNuevaContrasena)

        btnGuardarCambioContrasena.setOnClickListener {
            val new_contrasena = etNuevaContrasena.text.toString()
            val valid_contrasena = etValidaNuevaContrasena.text.toString()

            if (new_contrasena.isNotEmpty() && valid_contrasena.isNotEmpty()) {
                val intent = Intent(this, Loguearse::class.java)
                startActivity(intent)
                finishAffinity()
                Toast.makeText(this, "Contraseña actualizada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show()
            }

        }

    }
}