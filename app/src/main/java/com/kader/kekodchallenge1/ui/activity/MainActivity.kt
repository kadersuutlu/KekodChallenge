package com.kader.kekodchallenge1.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.kader.kekodchallenge1.R
import com.kader.kekodchallenge1.databinding.ActivityMainBinding
import com.kader.kekodchallenge1.ui.fragment.EgoFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
    }

    fun updateBottomNavigationMenu() {
        val menu = binding.bottomNavigation.menu
        menu.clear()

        menu.add(0, R.id.egoFragment, 0, "Ana Ekran").setIcon(R.drawable.ic_ego_icon)

        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment)?.childFragmentManager?.fragments?.firstOrNull() as? EgoFragment)?.let { egoFragment ->
            with(egoFragment.binding) {
                if (switchJoy.isChecked) menu.add(0, R.id.joyFragment, 1, "Joy").setIcon(R.drawable.ic_joy_icon)
                if (switchFear.isChecked) menu.add(0, R.id.fearFragment, 2, "Fear").setIcon(R.drawable.ic_fear_icon)
                if (switchAnger.isChecked) menu.add(0, R.id.angerFragment, 3, "Anger").setIcon(R.drawable.ic_angry_icon)
                if (switchDisgust.isChecked) menu.add(0, R.id.disgustFragment, 4, "Disgust").setIcon(R.drawable.ic_disgust_icon)
                if (switchSadness.isChecked) menu.add(0, R.id.sadnessFragment, 5, "Sadness").setIcon(R.drawable.ic_sad_icon)
            }
        }

        binding.bottomNavigation.visibility = if (menu.size() > 1) View.VISIBLE else View.GONE
    }

    fun hideBottomNavigation() {
        binding.bottomNavigation.visibility = View.GONE
    }

    fun showBottomNavigation() {
        binding.bottomNavigation.visibility = View.VISIBLE
    }
}