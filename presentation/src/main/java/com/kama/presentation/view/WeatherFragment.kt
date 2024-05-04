package com.kama.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.kama.core.base.BaseFragment
import com.kama.core.util.WeatherUtil
import com.kama.design.R
import com.kama.domain.model.WeatherDataEntity
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
        initAppBar()
        init()
    }

    private fun initViewModel() {
        Timber.i("$TAG::initViewModel()")
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    private fun initAppBar() {
        Timber.i("$TAG::initAppBar()")
        binding.layoutAppbar.tvTitle.text = getString(R.string.weather_title)
    }

    private fun init() {
        Timber.i("$TAG::init()")
        weatherDataReceive()
        swipeRefresh()
    }

    private fun weatherDataReceive() {
        Timber.i("$TAG::weatherDataReceive()")
        mainViewModel.result.observe(viewLifecycleOwner) { resultData ->
            Timber.d("$TAG::result.observe() $resultData")
            if (resultData) {
                weatherDataParsing(mainViewModel.weatherData)
            } else {
                Toast.makeText(requireContext(), getString(R.string.waiting_data), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun weatherDataParsing(weatherData: MutableList<WeatherDataEntity>) {
        Timber.i("$TAG::weatherDataParsing()")
        // 강수량 - 강수확률
        val rainAmount: MutableMap<String, String> = mutableMapOf()
        // 바람세기 - 풍속
        val windStrength: MutableMap<String, String> = mutableMapOf()
        // 날씨 형태 - 하늘상태
        val weatherShape: MutableMap<String, String> = mutableMapOf()
        // 3시간마다 날씨 - 3시간 기온
        val weatherEvery3Hours: MutableMap<String, String> = mutableMapOf()

        weatherData.forEach {
            val key = "${it.fcstDate};${it.fcstTime}"
            val value: String = it.fcstValue

            when(it.category) {
                "아침 최저기온" -> mainViewModel.minTemp = value
                "낮 최고기온" -> mainViewModel.maxTemp = value
                "1시간 기온" -> mainViewModel.currentTemp[key] = value
                "강수확률" -> rainAmount[key] = value
                "풍속" -> windStrength[key] = value
                "하늘상태" -> weatherShape[key] = value
                "3시간 기온" -> weatherEvery3Hours[key] = value
            }
        }

        // 강수량 - 강수확률
        rainAmount(rainAmount)
        // 바람세기 - 풍속
        windStrength(windStrength)
        // 날씨 형태 - 하늘상태
        weatherShape(weatherShape)
        // 3시간마다 날씨 - 3시간 기온
        weatherEvery3Hours(weatherEvery3Hours)
        // 내일 날씨 예보 - 1시간 기온
        tomorrowWeatherForecast()
    }

    // 강수량 - 강수확률
    private fun rainAmount(data: MutableMap<String, String>) {
        // 강수확률
        data.forEach { (key, value) ->
            Timber.i("$TAG::rainAmount() $key, $value")
        }
    }

    // 바람세기 - 풍속
    private fun windStrength(data: MutableMap<String, String>) {
        // 풍속
        data.forEach { (key, value) ->
            Timber.i("$TAG::windStrength() $key, $value")
        }
    }

    // 날씨 형태 - 하늘상태
    private fun weatherShape(data: MutableMap<String, String>) {
        // 하늘상태
        data.forEach { (key, value) ->
            Timber.i("$TAG::weatherShape() $key, $value")
        }
    }

    // 3시간마다 날씨 - 3시간 기온
    private fun weatherEvery3Hours(data: MutableMap<String, String>) {
        // 3시간 기온
        data.forEach { (key, value) ->
            Timber.i("$TAG::weatherEvery3Hours() $key, $value")
        }
    }

    // 내일 날씨 예보 - 1시간 기온 - viewmodel에 저장된 변수 사용
    private fun tomorrowWeatherForecast() {
        // 1시간 기온
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