package ComplementosInterfaz.administrador.Tarifas

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.rutas.R

class modificarTarifa : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modificar_tarifa)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnGuardarTarifaModificado: Button = findViewById(R.id.btnGuardarTarifaModificado)
        btnGuardarTarifaModificado.setOnClickListener {
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