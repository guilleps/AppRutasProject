package ComplementosInterfaz.Compartido.Inicio

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.rutas.R

class EnviarRecuperarion : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.enviar_recuperacion)

        val btnEnviarCode: Button = findViewById(R.id.btnEnviarCode)
        val etCorreoRecuperacion: EditText = findViewById(R.id.etCorreoRecuperacion)

        btnEnviarCode.setOnClickListener {
            val enviar = etCorreoRecuperacion.text.toString()

            if (enviar.isNotEmpty()) {
                val intent = Intent(this, ValidarRecuperacion::class.java)
                startActivity(intent)
                Toast.makeText(this, "Se ha enviado código", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Completar campo", Toast.LENGTH_SHORT).show()
            }

        }
    }
}