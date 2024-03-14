package ComplementosInterfaz.administrador.Choferes

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

class gestionarChoferes : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gestionar_choferes)

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnTodoChofer : AppCompatButton = findViewById(R.id.btnTodoChofer)
        btnTodoChofer.setOnClickListener {
            val intent = Intent(this, visualizarChoferes::class.java)
            startActivity(intent)
        }

        val btnModificarChofer : ImageButton =  findViewById(R.id.btnModificarChofer)
        btnModificarChofer.setOnClickListener {
            val intent = Intent(this, modificarChofer::class.java)
            startActivity(intent)
        }

        val btnAgregarChofer : ImageButton =  findViewById(R.id.btnAgregarChofer)
        btnAgregarChofer.setOnClickListener {
            val intent = Intent(this, agregarChofer::class.java)
            startActivity(intent)
        }

        val btnEliminarChofer : ImageButton =  findViewById(R.id.btnEliminarChofer)
        btnEliminarChofer.setOnClickListener {
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
            Toast.makeText(this, "gestionarChoferes eliminado", Toast.LENGTH_SHORT).show()
        }

        val btnEliminarCancelar: Button = view.findViewById(R.id.btnEliminarCancelar)
        btnEliminarCancelar.setOnClickListener {
            dialog.dismiss()
        }

        dialog = build.create()
        dialog.show()
    }
}