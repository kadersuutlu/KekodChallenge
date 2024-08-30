package com.kader.kekodchallenge1.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kader.kekodchallenge1.BaseFragment
import com.kader.kekodchallenge1.R
import com.kader.kekodchallenge1.databinding.FragmentDisgustBinding

class DisgustFragment : BaseFragment<FragmentDisgustBinding>() {

    override fun initView() {
        binding.includePageDetail.textView.text = getString(R.string.disgust)
        binding.includePageDetail.imageView.setImageResource(R.drawable.disgust)
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDisgustBinding = FragmentDisgustBinding.inflate(inflater,container,false)
}
