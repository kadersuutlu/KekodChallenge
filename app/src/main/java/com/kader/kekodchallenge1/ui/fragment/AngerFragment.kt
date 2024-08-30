package com.kader.kekodchallenge1.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kader.kekodchallenge1.BaseFragment
import com.kader.kekodchallenge1.R
import com.kader.kekodchallenge1.databinding.FragmentAngerBinding


class AngerFragment : BaseFragment<FragmentAngerBinding>() {

    override fun initView() {
        binding.includePageDetail.textView.text = getString(R.string.anger)
        binding.includePageDetail.imageView.setImageResource(R.drawable.angry)
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAngerBinding =FragmentAngerBinding.inflate(inflater,container,false)
}