package ComplementosInterfaz.administrador.Tarifas

import SQLite
import android.annotation.SuppressLint
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.rutas.R

class agregarTarifa : AppCompatActivity() {

    var txtNombreTarifa: EditText? = null
    var txtPrecioTarifa: EditText? = null
    var txtDescripcionTarifa: EditText? = null
    var txtRestriccionTarifa: EditText? = null
    var tableTarifa: TableLayout? = null
    private lateinit var dialog: AlertDialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agregar_tarifa)

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

    fun insertarTarifa(view: View) {
        var con = SQLite(this, "app", null, 1)
        var baseDatos = con.writableDatabase

        var nombreTarifa = txtNombreTarifa?.text.toString()
        var precioTarifa = txtPrecioTarifa?.text.toString()
        var descripcionTarifa = txtDescripcionTarifa?.text.toString()
        var restriccionTarifa = txtRestriccionTarifa?.text.toString()

        if (nombreTarifa.isNotEmpty() && precioTarifa.isNotEmpty() && descripcionTarifa.isNotEmpty() && restriccionTarifa.isNotEmpty()){
            var registro = ContentValues()

            registro.put("nombreTarifa", nombreTarifa)
            registro.put("precioTarifa", precioTarifa)
            registro.put("descripcionTarifa", descripcionTarifa)
            registro.put("restriccionTarifa", restriccionTarifa)

            baseDatos.insert("tarifarios", null, registro)

            txtNombreTarifa?.setText("")
            txtPrecioTarifa?.setText("")
            txtDescripcionTarifa?.setText("")
            txtRestriccionTarifa?.setText("")

            //baseDatos.close()

            showAlertDialog()

        } else {
            Toast.makeText(this, "Datos incompletos", Toast.LENGTH_LONG).show()
            return
        }


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