package ComplementosInterfaz.Compartido.Comentarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.rutas.R
import com.example.rutas.databinding.ActivityComentarioAgregarBinding

class Comentario : AppCompatActivity() {

    private lateinit var binding: ActivityComentarioAgregarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComentarioAgregarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val campoComentar: EditText = findViewById(R.id.campoComentar)
        val btnAtras: ImageView = findViewById(R.id.btnAtras)
        val btnPublicar: Button = findViewById(R.id.btnPublicar)

        btnAtras.setOnClickListener {
            finish()
        }

        val routes = resources.getStringArray(R.array.route_bus)
        val adapter = ArrayAdapter(
            this,
            R.layout.list_item,
            routes
        )

        with(binding.autoCompleteTextView) {
            setAdapter(adapter)
        }

        btnPublicar.setOnClickListener {
            val comentar = campoComentar.text.toString()

            if (comentar.isNotEmpty()) {
                finish()
                Toast.makeText(this, "Foro publicado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Porfavor, comente", Toast.LENGTH_SHORT).show()
            }
        }
    }
}