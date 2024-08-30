package com.kader.kekodchallenge1.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kader.kekodchallenge1.BaseFragment
import com.kader.kekodchallenge1.R
import com.kader.kekodchallenge1.databinding.FragmentJoyBinding

class JoyFragment : BaseFragment<FragmentJoyBinding>() {

    override fun initView() {
        binding.includePageDetail.textView.text = getString(R.string.joy)
        binding.includePageDetail.imageView.setImageResource(R.drawable.joy)
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentJoyBinding = FragmentJoyBinding.inflate(inflater,container,false)
}