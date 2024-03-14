package ComplementosInterfaz.pasajero.gestionarUsuario

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.rutas.R

class ModificarCuenta : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modificar_cuenta)

        val btnGuardarPerfil : Button = findViewById(R.id.btnGuardarPerfil)
        btnGuardarPerfil.setOnClickListener {
            //Toast.makeText(this, "PerfilFragment actualizado", Toast.LENGTH_SHORT).show()
            showAlertDialog()
        }

    }

    @SuppressLint("MissingInflatedId")
    private fun showAlertDialog() {
        val build = AlertDialog.Builder(this, R.style.ThemeCustomDialog)
        val view = layoutInflater.inflate(R.layout.custom_dialog_perfil, null)
        build.setView(view)

        val btnOK: Button = view.findViewById(R.id.btnOK)
        btnOK.setOnClickListener {
            dialog.dismiss()
            finish()
        }

        dialog = build.create()
        dialog.show()
    }
}