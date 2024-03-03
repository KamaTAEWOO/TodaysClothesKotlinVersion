package com.kama.presentation.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.kama.core.base.BaseFragment
import com.kama.presentation.databinding.FragmentMyStyleBinding
import com.kama.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MyStyleFragment : BaseFragment<FragmentMyStyleBinding>() {

    private val TAG = "WeatherFragment::"
    private lateinit var mainViewModel: MainViewModel

    override fun getFragmentBinding(): FragmentMyStyleBinding =
        FragmentMyStyleBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        init()
    }

    private fun initViewModel() {
        Timber.i("$TAG::initViewModel()")
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    private fun init() {
        Timber.i("$TAG::init()")
    }
}