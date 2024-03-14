package ComplementosInterfaz.administrador.Unidades

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.example.rutas.R

class gestionarUnidades : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gestionar_unidades)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnTodoUnidad : AppCompatButton = findViewById(R.id.btnTodoUnidad)
        btnTodoUnidad.setOnClickListener {
            val intent = Intent(this, visualizarUnidades::class.java)
            startActivity(intent)
        }

        val btnModificarUnidad: ImageButton = findViewById(R.id.btnModificarUnidad)
        btnModificarUnidad.setOnClickListener {
            val intent = Intent(this, modificarUnidad::class.java)
            startActivity(intent)
        }

        val btnAgregarUnidad: ImageButton = findViewById(R.id.btnAgregarUnidad)
        btnAgregarUnidad.setOnClickListener {
            val intent = Intent(this, agregarUnidad::class.java)
            startActivity(intent)
        }

        val btnEliminarUnidad: ImageButton = findViewById(R.id.btnEliminarUnidad)
        btnEliminarUnidad.setOnClickListener {
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
            Toast.makeText(this, "gestionarUnidades eliminada", Toast.LENGTH_SHORT).show()
        }

        val btnEliminarCancelar: Button = view.findViewById(R.id.btnEliminarCancelar)
        btnEliminarCancelar.setOnClickListener {
            dialog.dismiss()
        }


        dialog = build.create()
        dialog.show()
    }

}