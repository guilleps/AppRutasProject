package ComplementosInterfaz.pasajero.consultas

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.rutas.R

class ConsultarRutas : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.consultar_rutas)

        val btnAtras: ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }
    }
}