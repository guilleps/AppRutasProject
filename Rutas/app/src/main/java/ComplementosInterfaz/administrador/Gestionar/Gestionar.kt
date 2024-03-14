package ComplementosInterfaz.administrador.Gestionar

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.rutas.R
import ComplementosInterfaz.administrador.Choferes.gestionarChoferes
import ComplementosInterfaz.administrador.Comentarios.Foro
import ComplementosInterfaz.administrador.Horarios.gestionarHorarios
import ComplementosInterfaz.administrador.Rutas.gestionarRutas
import ComplementosInterfaz.administrador.Tarifas.gestionarTarifa
import ComplementosInterfaz.administrador.Unidades.gestionarUnidades

class Gestionar : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gestionar)

        val btnHorarios: CardView = findViewById(R.id.btnHorarios)
        btnHorarios.setOnClickListener {
            val intent = Intent(this, gestionarHorarios::class.java)
            startActivity(intent)
        }

        val btnTarifas: CardView = findViewById(R.id.btnTarifas)
        btnTarifas.setOnClickListener {
            val intent = Intent(this, gestionarTarifa::class.java)
            startActivity(intent)
        }

        val btnRutas: CardView = findViewById(R.id.btnRutas)
        btnRutas.setOnClickListener {
            val intent = Intent(this, gestionarRutas::class.java)
            startActivity(intent)
        }

        val btnComentarios: CardView = findViewById(R.id.btnComentarios)
        btnComentarios.setOnClickListener {
            val intent = Intent(this, Foro::class.java)
            startActivity(intent)
        }

        val btnConductores: CardView = findViewById(R.id.btnConductores)
        btnConductores.setOnClickListener {
            val intent = Intent(this, gestionarChoferes::class.java)
            startActivity(intent)
        }

        val btnUnidades: CardView = findViewById(R.id.btnUnidades)
        btnUnidades.setOnClickListener {
            val intent = Intent(this, gestionarUnidades::class.java)
            startActivity(intent)
        }
    }
}