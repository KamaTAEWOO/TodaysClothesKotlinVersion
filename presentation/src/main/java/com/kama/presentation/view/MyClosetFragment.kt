package com.kama.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kama.core.base.BaseFragment
import com.kama.presentation.R
import com.kama.presentation.databinding.FragmentMyClosetBinding
import com.kama.presentation.databinding.FragmentRecommendClothesBinding
import timber.log.Timber

class MyClosetFragment : BaseFragment<FragmentMyClosetBinding>() {

    private val TAG = "WeatherFragment::"

    override fun getFragmentBinding(): FragmentMyClosetBinding =
        FragmentMyClosetBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        Timber.i("$TAG::init()")
    }
}