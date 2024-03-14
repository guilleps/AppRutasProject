package ComplementosInterfaz.administrador.Rutas

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.rutas.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class modificarRuta : AppCompatActivity(), GoogleMap.OnMapClickListener,
    OnMapReadyCallback {

    private lateinit var dialog: AlertDialog
    private var marker: Marker? = null
    private lateinit var map: GoogleMap

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modificar_ruta)
        createMapFragment()

        val btnAtras : ImageView = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val btnGuardarRutaModificado: Button = findViewById(R.id.btnGuardarRutaModificado)
        btnGuardarRutaModificado.setOnClickListener {
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

    private fun createMapFragment() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapClick(latLng: LatLng) {
        map.addMarker(MarkerOptions().position(latLng))
        map.animateCamera(CameraUpdateFactory.newLatLng(latLng))
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.setOnMapClickListener(this)

        //Ubicacion por defecto(Trujillo)
        val location = LatLng(-8.11167, -79.0286)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14f))
    }
}