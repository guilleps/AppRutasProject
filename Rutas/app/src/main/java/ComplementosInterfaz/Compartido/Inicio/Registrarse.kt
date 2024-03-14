package ComplementosInterfaz.Compartido.Inicio

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import ComplementosInterfaz.pasajero.PasajeroMapa
import com.example.rutas.R

class Registrarse : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrarse)

        val etNombre: EditText = findViewById(R.id.etNombre)
        val etApellido: EditText = findViewById(R.id.etApellido)
        val etCorreoRegistro: EditText = findViewById(R.id.etCorreoRegistro)
        val etContrasenaRegistro: EditText = findViewById(R.id.etContrasenaRegistro)
        val etVerificacionRegistro: EditText = findViewById(R.id.etVerificacionRegistro)
        val btnCrearcuentaRegistro: Button = findViewById(R.id.btnCrearcuentaRegistro)

        btnCrearcuentaRegistro.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val correo = etCorreoRegistro.text.toString()
            val contrasena = etContrasenaRegistro.text.toString()
            val verificacion = etVerificacionRegistro.text.toString()

            if (nombre.isNotEmpty() && apellido.isNotEmpty() && correo.isNotEmpty() && contrasena.isNotEmpty() && verificacion.isNotEmpty()) {
                showAlertDialog()

            }

        }

    }

    @SuppressLint("MissingInflatedId")
    private fun showAlertDialog() {
        val build = AlertDialog.Builder(this, R.style.ThemeCustomDialog)
        val view = layoutInflater.inflate(R.layout.custom_dialog_bienvenido, null)
        build.setView(view)

        val btnOK: Button = view.findViewById(R.id.btnOK)
        btnOK.setOnClickListener {
            val intent = Intent(this, PasajeroMapa::class.java)
            startActivity(intent)
            //dialog.dismiss()
            finish()
        }

        dialog = build.create()
        dialog.show()
    }
}