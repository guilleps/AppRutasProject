package ComplementosInterfaz.pasajero

import ComplementosInterfaz.pasajero.Principal.Principal
import ComplementosInterfaz.pasajero.consultas.InformacionFragment
import ComplementosInterfaz.pasajero.gestionarUsuario.PerfilFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.rutas.R
import com.example.rutas.databinding.ActivityPasajeroMapaBinding

class PasajeroMapa : AppCompatActivity() {

    private lateinit var binding: ActivityPasajeroMapaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasajeroMapaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.inicio -> replaceFragment(Principal())
                R.id.perfil -> replaceFragment(PerfilFragment())
                R.id.comentar -> replaceFragment(ForoFragment())
                R.id.ajustes -> replaceFragment(AjustesFragment())
                R.id.informacion -> replaceFragment(InformacionFragment())
            }
            true
        }

        replaceFragment(Principal())

        binding.bottomNavigationView.selectedItemId = R.id.inicio

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}
