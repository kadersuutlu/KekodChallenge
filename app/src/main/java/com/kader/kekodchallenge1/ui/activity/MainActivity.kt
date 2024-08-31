package com.kader.kekodchallenge1.ui.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.kader.kekodchallenge1.R
import com.kader.kekodchallenge1.databinding.ActivityMainBinding
import com.kader.kekodchallenge1.ui.fragment.EgoFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val addedSwitchIds = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
    }

    fun updateBottomNavigationMenu() {
        val menu = binding.bottomNavigation.menu
        menu.clear()

        menu.add(0, R.id.egoFragment, 0, "Ego").setIcon(R.drawable.ic_ego_icon)

        val fragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            ?.childFragmentManager
            ?.fragments
            ?.firstOrNull { it is EgoFragment } as? EgoFragment

        fragment?.let { egoFragment ->
            val switches = listOf(
                R.id.joyFragment to egoFragment.binding.switchJoy,
                R.id.fearFragment to egoFragment.binding.switchFear,
                R.id.angerFragment to egoFragment.binding.switchAnger,
                R.id.disgustFragment to egoFragment.binding.switchDisgust,
                R.id.sadnessFragment to egoFragment.binding.switchSadness
            )

            switches.forEach { (fragmentId, switch) ->
                if (switch.isChecked) {
                    if (!addedSwitchIds.contains(fragmentId)) {
                        addedSwitchIds.add(fragmentId)
                    }
                } else {
                    addedSwitchIds.remove(fragmentId)
                }
            }

            addedSwitchIds.take(4).forEachIndexed { index, fragmentId ->
                val switchPair = switches.firstOrNull { it.first == fragmentId }
                if (switchPair != null) {
                    val switch = switchPair.second
                    menu.add(0, fragmentId, index + 1, switch.text)
                        .setIconTintList(null)
                        .setIcon(getIconForFragment(fragmentId))
                }
            }

            if (addedSwitchIds.size > 4) {
                switches.forEach { (fragmentId, switch) ->
                    if (addedSwitchIds.indexOf(fragmentId) >= 4) {
                        switch.isChecked = false
                    }
                }
                showWarning()
            }
        }

        binding.bottomNavigation.visibility = if (menu.size() > 1) View.VISIBLE else View.GONE
    }

    private fun showWarning() {
        Toast.makeText(this, getString(R.string.max), Toast.LENGTH_SHORT).show()
    }

    private fun getIconForFragment(fragmentId: Int): Drawable? {
        return when (fragmentId) {
            R.id.joyFragment -> getDrawable(R.drawable.ic_joy_icon)
            R.id.fearFragment -> getDrawable(R.drawable.ic_fear_icon)
            R.id.angerFragment -> getDrawable(R.drawable.ic_angry_icon)
            R.id.disgustFragment -> getDrawable(R.drawable.ic_disgust_icon)
            R.id.sadnessFragment -> getDrawable(R.drawable.ic_sad_icon)
            else -> null
        }
    }

    fun hideBottomNavigation() {
        binding.bottomNavigation.visibility = View.GONE
    }

    fun showBottomNavigation() {
        binding.bottomNavigation.visibility = View.VISIBLE
    }
}