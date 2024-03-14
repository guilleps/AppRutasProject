package ComplementosInterfaz.administrador.Horarios

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.rutas.R

class HorarioAgregar : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agregar_horario)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnGuardarHorario: Button = findViewById(R.id.btnGuardarHorario)
        btnGuardarHorario.setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        val build = AlertDialog.Builder(this, R.style.ThemeCustomDialog)
        val view = layoutInflater.inflate(R.layout.custom_dialog_agregar, null)
        build.setView(view)

        val btnGuardarConfirmar: Button = view.findViewById(R.id.btnGuardarConfirmar)
        btnGuardarConfirmar.setOnClickListener {
            finish()
        }

        dialog = build.create()
        dialog.show()
    }

}
fun ndjbvd(){

}