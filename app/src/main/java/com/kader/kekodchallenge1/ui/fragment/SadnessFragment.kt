package com.kader.kekodchallenge1.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kader.kekodchallenge1.BaseFragment
import com.kader.kekodchallenge1.R
import com.kader.kekodchallenge1.databinding.FragmentSadnessBinding

class SadnessFragment : BaseFragment<FragmentSadnessBinding>() {

    override fun initView() {
        binding.includePageDetail.textView.text = getString(R.string.sadness)
        binding.includePageDetail.imageView.setImageResource(R.drawable.sad)
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSadnessBinding = FragmentSadnessBinding.inflate(inflater,container,false)
}