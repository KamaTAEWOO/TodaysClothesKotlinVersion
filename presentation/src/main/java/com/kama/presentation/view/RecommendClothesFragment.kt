package com.kama.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.kama.core.base.BaseFragment
import com.kama.core.util.WeatherUtil
import com.kama.presentation.databinding.FragmentRecommendClothesBinding
import com.kama.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * TODO : 온도에 따른 옷을 어떻게 추천해줄건가?
 *
 * */

@AndroidEntryPoint
class RecommendClothesFragment : BaseFragment<FragmentRecommendClothesBinding>() {

    private val TAG = "WeatherFragment::"
    private lateinit var mainViewModel: MainViewModel

    // 온도
    private val tempArray = intArrayOf(4, 5, 9, 13, 17, 21, 25, 29)

    // 설문 조사에 따른 나의 스타일
    private val surveyStyle = "casual"
    // 설문 조사에 따른 나의 더위 타입 정도
    private val surveyHotType = "많이 탐"


    override fun getFragmentBinding(): FragmentRecommendClothesBinding =
        FragmentRecommendClothesBinding.inflate(layoutInflater)

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

        tempClothes()
    }

    /**
     * 날씨 최고 온도와 최저 온도에 따라 style을 추천
     * 설문조사에 따른 나의 스타일도 참고
     * */
    private fun tempClothes() {
        val lowTemp = 2
        val highTemp = 35

        // lowTemp에 따른 옷 추천
        for (i in tempArray) {
            if(tempArray.first() > lowTemp) {
                lowRecommendClothesCheck(i)
                break
            } else if(lowTemp > i) {
                lowRecommendClothesCheck(i)
                break
            }
        }

        // highTemp에 따른 옷 추천
        for (i in tempArray) {
            if(highTemp < i) {
                highRecommendClothesCheck(i)
                break
            } else if(tempArray.last() == i) {
                highRecommendClothesCheck(i)
            }
        }
    }

    private fun lowRecommendClothesCheck(temp: Int) {
        Timber.i("$TAG::lowRecommendClothesShow() lowTemp : $temp")
        // AAA AAB AAC AAD AAE 더위 많이 타는 타입
        // ABA ABB ABC ABD ABE 더위 적게 타는 타입
        // surveyHotType / surveyStyle -> AAA
        val myStyle = "AAA"
        recommendClothesShow(temp, myStyle)
    }

    private fun highRecommendClothesCheck(temp: Int) {
        Timber.i("$TAG::highRecommendClothesShow() lowTemp : $temp")
        // AAA AAB AAC AAD AAE 더위 많이 타는 타입
        // ABA ABB ABC ABD ABE 더위 적게 타는 타입
        // surveyHotType / surveyStyle -> AAA
        val myStyle = "AAA"
        recommendClothesShow(temp, myStyle)
    }

    // 최종 추천 옷 보여주깉
    private fun recommendClothesShow(temp: Int, style: String) {
        Timber.i("$TAG::recommendClothesShow() $temp, $style")

        // 아우터 - 최고 온도 : 3개, 최저 온도 : 3개
        // 상의 - 최고 온도 : 3개, 최저 온도 : 3개
        // 하의 - 최고 온도 : 3개, 최저 온도 : 3개
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