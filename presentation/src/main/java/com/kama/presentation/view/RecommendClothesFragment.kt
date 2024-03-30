package com.kama.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.kama.core.base.BaseFragment
import com.kama.core.util.WeatherUtil
import com.kama.presentation.clothes.ClothesStyleMan
import com.kama.presentation.clothes.ClothesStyleWoman
import com.kama.presentation.databinding.FragmentRecommendClothesBinding
import com.kama.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.Arrays

/**
 * TODO : 온도에 따른 옷을 어떻게 추천해줄건가?
 *
 * */

@AndroidEntryPoint
class RecommendClothesFragment : BaseFragment<FragmentRecommendClothesBinding>() {

    private val TAG = "RecommendClothesFragment::"
    private lateinit var mainViewModel: MainViewModel

    // 온도
    private val tempArray = intArrayOf(4, 5, 9, 12, 17, 20, 23, 28)

    // 설문 조사에 따른 나의 성별
    private val surveyGender = "남자"
    // 설문 조사에 따른 나의 스타일
    private val surveyStyle = "캐주얼"
    // 설문 조사에 따른 나의 더위 타입 정도
    private val surveyHotType = "많이"


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
        val lowTemp = 2 // 최저 온도
        val highTemp = 35 // 최고 온도

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
        val myStyle = surveyTypeStyleData(temp)
        val myStyleImg = surveyTypeStyleImg(myStyle)
        val myStyleText = surveyTypeStyleText(myStyle)
        recommendClotheLowTempShow(myStyleImg, myStyleText)
    }

    private fun highRecommendClothesCheck(temp: Int) {
        Timber.i("$TAG::highRecommendClothesShow() lowTemp : $temp")
        val myStyle = surveyTypeStyleData(temp)
        val myStyleImg = surveyTypeStyleImg(myStyle)
        val myStyleText = surveyTypeStyleText(myStyle)
        recommendClotheHighTempShow(myStyleImg, myStyleText)
    }

    /**
     * 정리
     * 남자 : A, 여자 : B
     * 더위 많이 타는 타입 : A, 더위 적게 타는 타입 : B
     * 캐주얼 스타일 : A, 빈티지 스타일 : B, 스트릿 스타일 : C, 댄디 스타일 : D, 스포티 스타일 : E
     * TODO : 해당 클래스에 사용된 변수들 모두 가지고 오는 함수를 만들어서 사용해 보기
     * */
    private fun surveyTypeStyleData(temp: Int) : String{
        var result = "";

        // 성별
        if(surveyGender == "남자") {
            result += "A"
        } else {
            result += "B"
        }

        // 더위 타입
        if(surveyHotType == "많이") {
            result += "A"
        } else {
            result += "B"
        }

        // 스타일
        when(surveyStyle) {
            "캐주얼" -> result += "A"
            "빈티지" -> result += "B"
            "스트릿" -> result += "C"
            "댄디" -> result += "D"
            "스포티" -> result += "E"
        }

        // 온도
        result += temp.toString()

        return result
    }

    private fun surveyTypeStyleImg(style: String) : IntArray {
        // 성별 확인
        if(surveyGender == "남자") {
            // 남자
            // 스타일 확인
            return when(surveyStyle) {
                "캐주얼" -> ClothesStyleMan.getInstance().getCasualStyle(style)
                "빈티지" -> ClothesStyleMan.getInstance().getVintageStyle(style)
                "스트릿" -> ClothesStyleMan.getInstance().getStreetStyle(style)
                "댄디" -> ClothesStyleMan.getInstance().getDandyStyle(style)
                "스포티" -> ClothesStyleMan.getInstance().getSportyStyle(style)
                else -> intArrayOf()
            }
        } else {
            // 여자
            return when(surveyStyle) {
                "캐주얼" -> ClothesStyleWoman.getInstance().getCasualStyle(style)
                "빈티지" -> ClothesStyleWoman.getInstance().getVintageStyle(style)
                "스트릿" -> ClothesStyleWoman.getInstance().getStreetStyle(style)
                "댄디" -> ClothesStyleWoman.getInstance().getDandyStyle(style)
                "스포티" -> ClothesStyleWoman.getInstance().getSportyStyle(style)
                else -> intArrayOf()
            }
        }
    }

    private fun surveyTypeStyleText(style: String) : Array<String> {
        // 성별 확인
        if(surveyGender == "남자") {
            // 남자
            // 스타일 확인
            return when(surveyStyle) {
                "캐주얼" -> ClothesStyleMan.getInstance().getCasualStyleText(style)
                "빈티지" -> ClothesStyleMan.getInstance().getVintageStyleText(style)
                "스트릿" -> ClothesStyleMan.getInstance().getStreetStyleText(style)
                "댄디" -> ClothesStyleMan.getInstance().getDandyStyleText(style)
                "스포티" -> ClothesStyleMan.getInstance().getSportyStyleText(style)
                else -> arrayOf()
            }
        } else {
            // 여자
            return when(surveyStyle) {
                "캐주얼" -> ClothesStyleWoman.getInstance().getCasualStyleText(style)
                "빈티지" -> ClothesStyleWoman.getInstance().getVintageStyleText(style)
                "스트릿" -> ClothesStyleWoman.getInstance().getStreetStyleText(style)
                "댄디" -> ClothesStyleWoman.getInstance().getDandyStyleText(style)
                "스포티" -> ClothesStyleWoman.getInstance().getSportyStyleText(style)
                else -> arrayOf()
            }
        }
    }

    // 최종 추천 옷 보여주는 함수 - 최고 기온
    private fun recommendClotheHighTempShow(styleImg: IntArray, myStyleText: Array<String>) {
        Timber.i("$TAG::recommendClotheHighTempShow() ${Arrays.toString(styleImg)} / ${Arrays.toString(myStyleText)} ")

        // 아우터 - 최고 온도 : 3개, 최저 온도 : 3개
        // 상의 - 최고 온도 : 3개, 최저 온도 : 3개
        // 하의 - 최고 온도 : 3개, 최저 온도 : 3개
    }

    // 최종 추천 옷 보여주는 함수 - 최저 기온
    private fun recommendClotheLowTempShow(styleImg: IntArray, myStyleText: Array<String>) {
        Timber.i("$TAG::recommendClotheLowTempShow() ${Arrays.toString(styleImg)} / ${Arrays.toString(myStyleText)} ")

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