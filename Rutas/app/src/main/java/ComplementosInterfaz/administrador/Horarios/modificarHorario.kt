package ComplementosInterfaz.administrador.Horarios

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.rutas.R

class modificarHorario : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modificar_horario)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnGuardarHorarioModificado: Button = findViewById(R.id.btnGuardarHorarioModificado)
        btnGuardarHorarioModificado.setOnClickListener {
            showAlertDialog()
        }
    }

    @SuppressLint("MissingInflatedId")
    private fun showAlertDialog() {
        val build = AlertDialog.Builder(this, R.style.ThemeCustomDialog)
        val view = layoutInflater.inflate(R.layout.custom_dialog_modificar, null)
        build.setView(view)

        val btnModificarConfirmar: Button = view.findViewById(R.id.btnModificarConfirmar)
        btnModificarConfirmar.setOnClickListener {
            finish()
        }

        dialog = build.create()
        dialog.show()
    }
}