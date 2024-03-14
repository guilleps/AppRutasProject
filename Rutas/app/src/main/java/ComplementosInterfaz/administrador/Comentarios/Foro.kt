package ComplementosInterfaz.administrador.Comentarios

import ComplementosInterfaz.Compartido.Comentarios.Comentario
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.rutas.R

class Foro : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.foro)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnComentarAdmin: Button = findViewById(R.id.btnComentarAdmin)
        btnComentarAdmin.setOnClickListener {
            val intent = Intent(this, Comentario::class.java)
            startActivity(intent)
        }

    }
}