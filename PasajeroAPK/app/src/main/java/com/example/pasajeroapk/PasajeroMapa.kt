package com.example.pasajeroapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pasajeroapk.databinding.ActivityPasajeroMapaBinding
import com.example.pasajeroapk.menu_bottom.AjustesFragment
import com.example.pasajeroapk.menu_bottom.ForoFragment
import com.example.pasajeroapk.menu_bottom.InformacionFragment
import com.example.pasajeroapk.menu_bottom.MapaFragment
import com.example.pasajeroapk.menu_bottom.PerfilFragment

class PasajeroMapa : AppCompatActivity() {

    private lateinit var binding: ActivityPasajeroMapaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasajeroMapaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.inicio -> replaceFragment(MapaFragment())
                R.id.perfil -> replaceFragment(PerfilFragment())
                R.id.comentar -> replaceFragment(ForoFragment())
                R.id.ajustes -> replaceFragment(AjustesFragment())
                R.id.informacion -> replaceFragment(InformacionFragment())
            }
            true
        }

        replaceFragment(MapaFragment())

        binding.bottomNavigationView.selectedItemId = R.id.inicio

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}
