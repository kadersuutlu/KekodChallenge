package com.kader.kekodchallenge1.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kader.kekodchallenge1.BaseFragment
import com.kader.kekodchallenge1.R
import com.kader.kekodchallenge1.ui.activity.MainActivity
import com.kader.kekodchallenge1.databinding.FragmentEgoBinding

class EgoFragment : BaseFragment<FragmentEgoBinding>() {

    private lateinit var emotions: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        emotions = resources.getStringArray(R.array.emotions_array).toList()
    }

    override fun initView() {
        binding.switchEgo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                handleSwitchEgoChecked()
            } else {
                handleSwitchEgoUnchecked()
            }
        }

        listOf(
            binding.switchJoy,
            binding.switchFear,
            binding.switchAnger,
            binding.switchDisgust,
            binding.switchSadness
        ).forEach { switch ->
            switch.setOnCheckedChangeListener { _, _ ->
                (activity as MainActivity).updateBottomNavigationMenu()
            }
        }
    }

    private fun handleSwitchEgoChecked() {
        setSwitchesEnabled(false)
        (activity as MainActivity).hideBottomNavigation()
    }

    private fun handleSwitchEgoUnchecked() {
        setSwitchesEnabled(true)
        (activity as MainActivity).updateBottomNavigationMenu()
        (activity as MainActivity).showBottomNavigation()
    }

    private fun setSwitchesEnabled(isEnabled: Boolean) {
        binding.switchAnger.isEnabled = isEnabled
        binding.switchDisgust.isEnabled = isEnabled
        binding.switchFear.isEnabled = isEnabled
        binding.switchSadness.isEnabled = isEnabled
        binding.switchJoy.isEnabled = isEnabled
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEgoBinding = FragmentEgoBinding.inflate(inflater, container, false)
}