package ComplementosInterfaz.administrador.Tarifas

import SQLite
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.rutas.R

class gestionarTarifa : AppCompatActivity() {

    var txtNombreTarifa: EditText? = null
    var txtPrecioTarifa: EditText? = null
    var txtDescripcionTarifa: EditText? = null
    var txtRestriccionTarifa: EditText? = null
    var tableTarifa: TableLayout? = null
    private lateinit var dialog: AlertDialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gestionar_tarifas)

        txtNombreTarifa = findViewById(R.id.txtNombreTarifa)
        txtPrecioTarifa = findViewById(R.id.txtPrecioTarifa)
        txtDescripcionTarifa = findViewById(R.id.txtDescripcionTarifa)
        txtRestriccionTarifa = findViewById(R.id.txtRestriccionTarifa)
        tableTarifa = findViewById(R.id.tableTarifa)
        loadTableTarifa()

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }
/*
        val btnModificarTarifa: ImageButton = findViewById(R.id.btnModificarTarifa)
        btnModificarTarifa.setOnClickListener {
            val intent = Intent(this, modificarTarifa::class.java)
            startActivity(intent)
        }*/

        val btnAgregarTarifa: ImageButton = findViewById(R.id.btnAgregarTarifa)
        btnAgregarTarifa.setOnClickListener {
            val intent = Intent(this, agregarTarifa::class.java)
            startActivity(intent)
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
            Toast.makeText(this, "gestionarTarifa eliminada", Toast.LENGTH_SHORT).show()
        }

        val btnEliminarCancelar: Button = view.findViewById(R.id.btnEliminarCancelar)
        btnEliminarCancelar.setOnClickListener {
            dialog.dismiss()
        }

        dialog = build.create()
        dialog.show()
    }

    fun eliminarTarifa(view: View) {
        val con = SQLite(this, "app", null, 1)
        val baseDatos = con.writableDatabase
        val nombreTarifa = (view.parent as TableRow).findViewById<TextView>(R.id.table_NombreTarifa).text.toString()

        if (nombreTarifa.isNotEmpty()) {
            val cant = baseDatos.delete("tarifarios", "nombreTarifa = '$nombreTarifa'", null)
            if (cant > 0) {
                Toast.makeText(this, "Se elimino el tarifario", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No se encontro el tarifario", Toast.LENGTH_LONG).show()
            }

            txtNombreTarifa?.setText("")
            txtPrecioTarifa?.setText("")
            txtDescripcionTarifa?.setText("")
            txtRestriccionTarifa?.setText("")

        } else {
            Toast.makeText(this, "Indica el nombre de tarifa", Toast.LENGTH_LONG).show()
        }

        loadTableTarifa()

    }

    @SuppressLint("MissingInflatedId")
    fun loadTableTarifa() {
        tableTarifa?.removeAllViews()
        val con = SQLite(this, "app", null, 1)
        val baseDatos = con.writableDatabase

        val fila = baseDatos.rawQuery(
            "SELECT nombreTarifa,precioTarifa FROM tarifarios",
            null
        )

        if (fila.moveToFirst()) {
            do {
                val registro = LayoutInflater.from(this).inflate(
                    R.layout.item_table_layout_tarifa,
                    null,
                    false
                )
                val table_NombreTarifa = registro.findViewById<TextView>(R.id.table_NombreTarifa)
                val table_PrecioTarifa = registro.findViewById<TextView>(R.id.table_PrecioTarifa)

                table_NombreTarifa.text = fila.getString(0)
                table_PrecioTarifa.text = fila.getString(1)

                tableTarifa?.addView(registro)
            } while (fila.moveToNext())
        } else {
            Toast.makeText(this, "No existen tarifas", Toast.LENGTH_LONG).show()
        }

        fila.close()
        baseDatos.close()
    }

}