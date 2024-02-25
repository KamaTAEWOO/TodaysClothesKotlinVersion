package com.kama.presentation.view

import android.os.Bundle
import android.view.View
import com.kama.core.base.BaseFragment
import com.kama.presentation.databinding.FragmentRecommendClothesBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class RecommendClothesFragment : BaseFragment<FragmentRecommendClothesBinding>() {

    private val TAG = "WeatherFragment::"

    override fun getFragmentBinding(): FragmentRecommendClothesBinding =
        FragmentRecommendClothesBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        Timber.i("$TAG::init()")
    }
}