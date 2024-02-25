package com.kama.presentation.view

import android.os.Bundle
import android.view.View
import com.kama.core.base.BaseFragment
import com.kama.presentation.databinding.FragmentMyStyleBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MyStyleFragment : BaseFragment<FragmentMyStyleBinding>() {

    private val TAG = "WeatherFragment::"
//    private lateinit var weatherDataViewModel: WeatherDataViewModel

    override fun getFragmentBinding(): FragmentMyStyleBinding =
        FragmentMyStyleBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        Timber.i("$TAG::init()")
    }
}