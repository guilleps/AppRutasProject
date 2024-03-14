package ComplementosInterfaz.Compartido.Inicio

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.rutas.R

class ValidarRecuperacion : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.validar_recuperacion)

        val btnValidarCode: Button = findViewById(R.id.btnValidarCode)
        val btnReenviarCode: Button = findViewById(R.id.btnReenviarCode)
        val etCorreoRecuperacion: EditText = findViewById(R.id.etCorreoRecuperacion)

        btnReenviarCode.setOnClickListener {
            Toast.makeText(this, "Código reenviado", Toast.LENGTH_SHORT).show()
        }

        btnValidarCode.setOnClickListener {
            val validar = etCorreoRecuperacion.text.toString()

            if (validar.isNotEmpty()) {
                val intent = Intent(this, FinalizarRecuperacion::class.java)
                startActivity(intent)
                Toast.makeText(this, "Código válido", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Código inválido", Toast.LENGTH_SHORT).show()
            }
        }

    }
}