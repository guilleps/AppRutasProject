package ComplementosInterfaz.administrador.Choferes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.rutas.R

class agregarChofer : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agregar_chofer)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnGuardarChofer: Button = findViewById(R.id.btnGuardarChofer)
        btnGuardarChofer.setOnClickListener {
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