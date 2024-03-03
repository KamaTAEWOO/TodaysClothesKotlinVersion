package com.kama.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.kama.core.base.BaseFragment
import com.kama.core.util.WeatherUtil
import com.kama.design.R
import com.kama.presentation.databinding.FragmentWeatherBinding
import com.kama.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class WeatherFragment : BaseFragment<FragmentWeatherBinding>() {

    private val TAG = "WeatherFragment::"
    private lateinit var mainViewModel: MainViewModel

    override fun getFragmentBinding(): FragmentWeatherBinding =
        FragmentWeatherBinding.inflate(layoutInflater)

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
        weatherDataReceive()
        swipeRefresh()
    }

    private fun weatherDataReceive() {
        Timber.i("$TAG::weatherDataReceive()")

        var data = ""
        mainViewModel.result.observe(viewLifecycleOwner) { resultData ->
            Timber.d("$TAG::result.observe() $resultData")
            if (resultData) {
                mainViewModel.weatherData.forEach {
                    if (it.baseDate == it.fcstDate) {
                        data += "${it.category} -> ${it.fcstValue} \n"
                    }
                }
                binding.textView.text = data
            } else {
                Toast.makeText(requireContext(), getString(R.string.waiting_data), Toast.LENGTH_SHORT).show()
            }
        }
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