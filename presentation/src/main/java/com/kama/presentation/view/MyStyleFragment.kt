package com.kama.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.kama.core.base.BaseFragment
import com.kama.core.util.WeatherUtil
import com.kama.presentation.databinding.FragmentMyStyleBinding
import com.kama.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * TODO : 나만에 스타일 앨범 만들기 - 캡쳐 사진 모아서 올릴 수 있는 공간
 * */

@AndroidEntryPoint
class MyStyleFragment : BaseFragment<FragmentMyStyleBinding>() {

    private val TAG = "MyStyleFragment::"
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

    private fun swipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            mainViewModel.requestWeatherData(
                WeatherUtil.PAGE_NO,
                WeatherUtil.NUM_OF_ROWS,
                WeatherUtil.DATA_TYPE,
                WeatherUtil.BASE_DATE,
                WeatherUtil.BASE_TIME,
                WeatherUtil.NX,
                WeatherUtil.NY
            )
            Toast.makeText(requireContext(), "스와이프 완료", Toast.LENGTH_SHORT).show()
            binding.swipeRefreshLayout.isRefreshing = false // 새로고침 완료
        }
    }
}