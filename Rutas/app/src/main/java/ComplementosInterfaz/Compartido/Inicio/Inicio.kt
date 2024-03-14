package ComplementosInterfaz.Compartido.Inicio

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.rutas.R

class Inicio : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio)

        val btnStart: Button = findViewById(R.id.btnStart)

        btnStart.setOnClickListener {
            val intent = Intent(this, Loguearse::class.java)
            startActivity(intent)
        }
    }
}