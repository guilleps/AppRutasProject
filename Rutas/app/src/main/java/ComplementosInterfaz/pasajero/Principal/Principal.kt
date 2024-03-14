package ComplementosInterfaz.pasajero.Principal

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.rutas.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Principal.newInstance] factory method to
 * create an instance of this fragment.
 */
class Principal : Fragment(), OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener,
    GoogleMap.OnMapClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var map: GoogleMap
    private var marker: Marker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_mapa, container, false)
        val view = inflater.inflate(R.layout.principal, container, false)
        createMapFragment()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createMapFragment()
    }

    private fun createMapFragment() {
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Principal.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Principal().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        const val REQUEST_CODE_LOCATION = 0
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        //createMarker()
        //map.setOnMyLocationButtonClickListener(this)
        enableMyLocation()

        map.setOnMapClickListener(this)

        //Ubicacion por defecto(Trujillo)
        val location = LatLng(-8.11167, -79.0286)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14f))
    }

    private fun createMarker() {
        val favoritePlace = LatLng(-8.128126546831847, -79.03338351362898)
        map.addMarker(MarkerOptions().position(favoritePlace))
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(favoritePlace, 18f),
            4000,
            null
        )
    }

    private fun isPermissionsGranted() = ContextCompat.checkSelfPermission(
        requireContext(),
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    private fun enableMyLocation() {
        if (!::map.isInitialized) return
        if (isPermissionsGranted()) {
            map.isMyLocationEnabled = true
            map.uiSettings.isMyLocationButtonEnabled = true
            // Cambia la posición del botón de ubicación actual
            map.setPadding(0, 150, 0, 0)
        } else {
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
            Toast.makeText(
                requireContext(),
                "Ve a ajustes y acepta los permisos",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION
            )
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            REQUEST_CODE_LOCATION -> if(grantResults.isNotEmpty() && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                map.isMyLocationEnabled = true
            }else{
                Toast.makeText(
                    requireContext(),
                    "Para activar la localización ve a ajustes y acepta los permisos",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {}
        }
    }

    override fun onResume() {
        super.onResume()
        if (!::map.isInitialized) return
        if (!isPermissionsGranted()) {
            map.isMyLocationEnabled = false
            Toast.makeText(
                requireContext(),
                "Para activar la localización ve a ajustes y acepta los permisos",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(requireContext(), "Boton pulsado", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun onMapClick(latLng: LatLng) {
        if (marker != null) {
            marker?.remove()
        }
        marker = map.addMarker(MarkerOptions().position(latLng))
        map.animateCamera(CameraUpdateFactory.newLatLng(latLng))
    }


}