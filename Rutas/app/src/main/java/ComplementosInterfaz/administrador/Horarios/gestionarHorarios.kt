package ComplementosInterfaz.administrador.Horarios

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

class gestionarHorarios : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gestionar_horarios)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnModificarHorario: ImageButton = findViewById(R.id.btnModificarHorario)
        btnModificarHorario.setOnClickListener {
            val intent = Intent(this, modificarHorario::class.java)
            startActivity(intent)
        }

        val btnAgregarHorario: ImageButton = findViewById(R.id.btnAgregarHorario)
        btnAgregarHorario.setOnClickListener {
            val intent = Intent(this, HorarioAgregar::class.java)
            startActivity(intent)
        }

        val btnEliminarHorario: ImageButton = findViewById(R.id.btnEliminarHorario)
        btnEliminarHorario.setOnClickListener {
            showAlertDialog()
            finishActivity(R.layout.custom_dialog_eliminar)
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
            Toast.makeText(this, "gestionarHorarios eliminado", Toast.LENGTH_SHORT).show()
        }

        val btnEliminarCancelar: Button = view.findViewById(R.id.btnEliminarCancelar)
        btnEliminarCancelar.setOnClickListener {
            dialog.dismiss()
        }

        dialog = build.create()
        dialog.show()
    }

}