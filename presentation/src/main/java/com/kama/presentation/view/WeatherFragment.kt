package com.kama.presentation.view

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.kama.core.base.BaseFragment
import com.kama.core.util.WeatherUtil
import com.kama.design.R
import com.kama.domain.model.WeatherDataEntity
import com.kama.presentation.adapter.WeatherHourAdapter
import com.kama.presentation.data.WeatherHourData
import com.kama.presentation.databinding.FragmentWeatherBinding
import com.kama.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.Calendar

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
        binding.tvLocation.text = MainViewActivity.myLocation
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
        // 습도
        val humidity: MutableMap<String, String> = mutableMapOf()
        // 풍향
        val windDirection: MutableMap<String, String> = mutableMapOf()
        // 강수형태
        val rainType: MutableMap<String, String> = mutableMapOf()

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
                "습도" -> humidity[key] = value
                "풍향" -> windDirection[key] = value
                "강수형태" -> rainType[key] = value
            }
        }

        // 강수량 - 강수확률
        rainAmount(rainAmount)
        // 바람세기 - 풍속
        windStrength(windStrength)
        // 날씨 형태 - 하늘상태
        weatherShape(weatherShape, rainType)
        // 내일 날씨 예보 - 1시간 기온
        tomorrowWeatherForecast()
        // 습도
        humidity(humidity)
        // 풍향
        windDirection(windDirection)
    }

    private fun currentParsingDate(): String {
        val currentTime: String = WeatherUtil.getCurrentDateTime()
        val currentTimeList = currentTime.split(";")
        return "${currentTimeList[0]};${currentTimeList[1].substring(0, 2)}00"
    }

    // 강수량 - 강수확률
    private fun rainAmount(data: MutableMap<String, String>) {
       val currentParsingDate = currentParsingDate() // parsing 중 현재 날짜와 시간이 달라질 수 있음.

        // 강수확률
        data.forEach { (key, value) ->
            Timber.i("$TAG::rainAmount() $key, $value")
            if (key == currentParsingDate) {
                binding.tvRainValue.text = value
            }
        }
    }

    // 바람세기 - 풍속
    private fun windStrength(data: MutableMap<String, String>) {
        val currentParsingDate = currentParsingDate()

        // 풍속
        data.forEach { (key, value) ->
            Timber.i("$TAG::windStrength() $key, $value")
            if (key == currentParsingDate) {
                binding.tvWindValue.text = value
            }
        }
    }

    // 날씨 형태 - 하늘상태
    private fun weatherShape(data: MutableMap<String, String>, rainType: MutableMap<String, String>) {
        val currentParsingDate = currentParsingDate()
        // TODO : 맑음: ic_sun, 구름맑음: ic_cloudy, 흐림: ic_cloud
        // TODO : 눈: ic_snowy, 비: ic_rainy

        // 하늘상태
        data.forEach { (key, value) ->
            Timber.i("$TAG::weatherShape() $key, $value")
            if (key == currentParsingDate) {
                // 이미지 변경함.
                binding.ivWeather.setImageResource(
                    when (skyState(value)) {
                        "맑음" -> R.drawable.ic_sun
                        "구름맑음" -> R.drawable.ic_cloudy
                        "흐림" -> rainType(rainType)
                        else -> {}
                    } as Int
                )
            }
        }
    }

    // 하늘 상태
    private fun skyState(skyData: String): String? {
        when (skyData) {
            "1" -> return "맑음"
            "3" -> return "구름맑음"
            "4" -> return "흐림"
        }
        //Timber.d("$TAG::skyState() $skyData")
        return skyData
    }

    // 강수형태
    private fun rainType(data: MutableMap<String, String>): Int {
        val currentParsingDate = currentParsingDate()

        data.forEach { (key, value) ->
            Timber.i("$TAG::rainType() $key, $value")
            if (key == currentParsingDate) {
                return when (value) {
                    "0" -> R.drawable.ic_cloud
                    "1" -> R.drawable.ic_rainy
                    "2" -> R.drawable.ic_rainy
                    "3" -> R.drawable.ic_snowy
                    "4" -> R.drawable.ic_rainy
                    "5" -> R.drawable.ic_rainy
                    "6" -> R.drawable.ic_rainy
                    "7" -> R.drawable.ic_snowy
                    else -> {0}
                }
            }
        }
        return 0
    }

    // 내일 날씨 예보 - 1시간 기온 - viewmodel에 저장된 변수 사용
    private fun tomorrowWeatherForecast() {
        val currentParsingDate = currentParsingDate()
        val hourData = mutableListOf<WeatherHourData>()
        var dataCount = 0

        // 현재 시간
        val currentTime = Calendar.getInstance()
        val currentHour = currentTime.get(Calendar.HOUR_OF_DAY)

        // 1시간 기온
        mainViewModel.currentTemp.forEach { (key, value) ->
            Timber.i("$TAG::tomorrowWeatherForecast() $key, $value")
            if (key == currentParsingDate) {
                // 현재 온도
                binding.tvCurrentTempValue.text = "$value°C"
            }
            // key: 20240302;0500 -> 0500
            if (WeatherUtil.dataSplit(key).first == WeatherUtil.BASE_DATE) {
                val time = WeatherUtil.dataSplit(key)
                val hour = time.second.substring(0, 2).toInt()
                // 현재 시간 이후의 데이터만 추가하고, 최대 10개의 데이터를 가져옴
                if (hour >= currentHour && dataCount < 10) {
                    hourData.add(WeatherHourData(time.second, value))
                    dataCount++
                }
            }
        }

        val adapter = WeatherHourAdapter(hourData)
        binding.rvHourlyWeather.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvHourlyWeather.adapter = adapter

        makeLineChart(binding.chart, hourData)
    }

    private fun makeLineChart(lineChart: LineChart, hourData: List<WeatherHourData>) {
        Timber.i("$TAG::makeLineChart()")

        val entries = ArrayList<Entry>()
        val time = ArrayList<String>() // X축 레이블을 저장할 리스트

        hourData.forEachIndexed { index, data ->
            entries.add(Entry(index.toFloat(), data.temperature.toFloat()))
            time.add(index.toString()) // index를 레이블 리스트에 추가
        }

        val dataSet = LineDataSet(entries, "Hourly Temperature")
        dataSet.color = Color.BLUE
        dataSet.valueTextColor = Color.BLACK
        dataSet.setDrawValues(false) // 데이터 값 표시 비활성화

        val lineData = LineData(dataSet)

        lineChart.data = lineData
        lineChart.setTouchEnabled(true)
        lineChart.isDragEnabled = true
        lineChart.setScaleEnabled(true)
        lineChart.setPinchZoom(true)

        // Y축 레이블 숨기기
        lineChart.axisRight.setDrawLabels(false)
        lineChart.axisLeft.granularity = 1f

        // X축 레이블 숨기기
        lineChart.xAxis.setDrawLabels(false)

        lineChart.invalidate()
    }

    // 습도
    private fun humidity(data: MutableMap<String, String>) {
        val currentParsingDate = currentParsingDate()

        // 습도
        data.forEach { (key, value) ->
            Timber.i("$TAG::humidity() $key, $value")
            if (key == currentParsingDate) {
                binding.tvHumidityValue.text = value
            }
        }
    }

    // 풍향
    private fun windDirection(data: MutableMap<String, String>) {
        val currentParsingDate = currentParsingDate()

        // 풍향
        data.forEach { (key, value) ->
            Timber.i("$TAG::windDirection() $key, $value")
            if (key == currentParsingDate) {
                binding.tvWindDirectionValue.text = parseWindDirection(value.toInt())
            }
        }
    }

    private fun parseWindDirection(degrees: Int): String {
        val directions = arrayOf("북", "북동", "동", "남동", "남", "남서", "서", "북서")
        val index = ((degrees % 360) / 45).toInt()
        return directions[index]
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