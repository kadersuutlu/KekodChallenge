package com.kader.kekodchallenge1.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kader.kekodchallenge1.BaseFragment
import com.kader.kekodchallenge1.R
import com.kader.kekodchallenge1.databinding.FragmentFearBinding

class FearFragment : BaseFragment<FragmentFearBinding>() {

    override fun initView() {
        binding.includePageDetail.textView.text = getString(R.string.fear)
        binding.includePageDetail.imageView.setImageResource(R.drawable.fear)
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFearBinding = FragmentFearBinding.inflate(inflater,container,false)
}