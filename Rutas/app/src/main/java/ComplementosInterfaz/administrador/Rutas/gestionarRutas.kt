package ComplementosInterfaz.administrador.Rutas

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.rutas.R

class gestionarRutas : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gestionar_rutas)

        val btnAtras: ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnModificarRuta: ImageButton = findViewById(R.id.btnModificarRuta)
        btnModificarRuta.setOnClickListener {
            val intent = Intent(this, modificarRuta::class.java)
            startActivity(intent)
        }

        val btnAgregarRuta: ImageButton = findViewById(R.id.btnAgregarRuta)
        btnAgregarRuta.setOnClickListener {
            val intent = Intent(this, agregarRuta::class.java)
            startActivity(intent)
        }

        val btnEliminarRuta: ImageButton = findViewById(R.id.btnEliminarRuta)
        btnEliminarRuta.setOnClickListener {
            showAlertDialog()
        }

    }

    @SuppressLint("MissingInflatedId")
    private fun showAlertDialog() {
        val build = AlertDialog.Builder(this, R.style.ThemeCustomDialog)
        val view = layoutInflater.inflate(R.layout.custom_dialog_eliminar, null)
        build.setView(view)

        val btnEliminarConfirmar: Button = view.findViewById(R.id.btnEliminarConfirmar)
        btnEliminarConfirmar.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "gestionarRutas eliminada", Toast.LENGTH_SHORT).show()
        }

        val btnEliminarCancelar: Button = view.findViewById(R.id.btnEliminarCancelar)
        btnEliminarCancelar.setOnClickListener {
            dialog.dismiss()
        }

        dialog = build.create()
        dialog.show()
    }

}