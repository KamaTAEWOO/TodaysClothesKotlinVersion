package com.kama.presentation.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.kama.core.base.BaseActivity
import com.kama.core.util.WeatherUtil
import com.kama.design.R
import com.kama.presentation.databinding.ActivityMyStyleSurveyBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MyStyleSurveyActivity : BaseActivity<ActivityMyStyleSurveyBinding>() {
    private val TAG = "MyStyleSurveyActivity"

    override fun getActivityBinding(): ActivityMyStyleSurveyBinding =
        ActivityMyStyleSurveyBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        val message = intent.getStringExtra("option")
        if(message == "option") {
            WeatherUtil.loadSharedPreferenceData(this, WeatherUtil.SURVEY_DATA_KEY)?.let {
                val surveyData = it.split(",")
                surveySex = surveyData[0]
                surveyHeat = surveyData[1]
                surveyStyle = surveyData[2]
            }
            init()
            initAppBar()
            setData()
        } else {
            if(WeatherUtil.loadSharedPreferenceData(this, WeatherUtil.SURVEY_DATA_KEY)?.isNotEmpty() == true) {
                WeatherUtil.loadSharedPreferenceData(this, WeatherUtil.SURVEY_DATA_KEY)?.let {
                    val surveyData = it.split(",")
                    surveySex = surveyData[0]
                    surveyHeat = surveyData[1]
                    surveyStyle = surveyData[2]
                }
                startActivity(Intent(this, MainViewActivity::class.java))
                finish()
            } else {
                initAppBar()
                init()
            }
        }
    }

    private fun initAppBar() {
        Timber.i("$TAG::initAppBar()")
        binding.layoutAppbar.tvTitle.text = getString(R.string.survey_title)
    }

    private fun init() {
        binding.rgSurveySex.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton: RadioButton? = binding.root.findViewById(checkedId)
            selectedRadioButton?.let {
                val selectedText = it.text.toString()
                Timber.i("$TAG::rgSurveySex: $selectedText")
                surveySex = selectedText
            }
        }

        binding.rgSurveyHeat.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton: RadioButton? = binding.root.findViewById(checkedId)
            selectedRadioButton?.let {
                val selectedText = it.text.toString()
                Timber.i("$TAG::rgSurveyHeat: $selectedText")
                surveyHeat = selectedText
            }
        }

        binding.rgSurveyStyle.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton: RadioButton? = binding.root.findViewById(checkedId)
            selectedRadioButton?.let {
                val selectedText = it.text.toString()
                Timber.i("$TAG::rgSurveyStyle: $selectedText")
                surveyStyle = selectedText
            }
        }
    }

    private fun setData() {
        if(surveySex.isNotEmpty()) {
            when(surveySex) {
                getString(R.string.survey_sex_man) -> binding.rgSurveySex.check(com.kama.presentation.R.id.rb_man)
                getString(R.string.survey_sex_woman) -> binding.rgSurveySex.check(com.kama.presentation.R.id.rb_woman)
            }
        }

        if(surveyHeat.isNotEmpty()) {
            when(surveyHeat) {
                getString(R.string.survey_heat_very) -> binding.rgSurveyHeat.check(com.kama.presentation.R.id.rb_much_heat)
                getString(R.string.survey_heat_little) -> binding.rgSurveyHeat.check(com.kama.presentation.R.id.rb_little_heat)
            }
        }

        if(surveyStyle.isNotEmpty()) {
            when(surveyStyle) {
                getString(R.string.survey_style_casual) -> binding.rgSurveyStyle.check(com.kama.presentation.R.id.rb_style_casual)
                getString(R.string.survey_style_street) -> binding.rgSurveyStyle.check(com.kama.presentation.R.id.rb_style_street)
                getString(R.string.survey_style_vintage) -> binding.rgSurveyStyle.check(com.kama.presentation.R.id.rb_style_vintage)
                getString(R.string.survey_style_dandy) -> binding.rgSurveyStyle.check(com.kama.presentation.R.id.rb_style_dandy)
                getString(R.string.survey_style_sporty) -> binding.rgSurveyStyle.check(com.kama.presentation.R.id.rb_style_sporty)
            }
        }
    }

    fun onConfirmClick(v: View) {
        Timber.i("$TAG::onConfirmClick()")
        Toast.makeText(this, getString(R.string.survey_complete), Toast.LENGTH_SHORT).show()
        val surveyData = "$surveySex,$surveyHeat,$surveyStyle"
        WeatherUtil.clearAccessToken(this, WeatherUtil.SURVEY_DATA_KEY)
        WeatherUtil.saveSharedPreferenceData(this, WeatherUtil.SURVEY_DATA_KEY, surveyData)
        startActivity(Intent(this, MainViewActivity::class.java))
        finish()
    }

    fun onCancelClick(v: View) {
        Timber.i("$TAG::onCancelClick()")
        Toast.makeText(this, getString(R.string.survey_error), Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainViewActivity::class.java))
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainViewActivity::class.java))
    }

    companion object {
        // survey
        var surveySex = ""
        var surveyHeat = ""
        var surveyStyle = ""
    }
}