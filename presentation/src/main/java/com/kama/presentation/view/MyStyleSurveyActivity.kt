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

        if(WeatherUtil.loadSharedPreferenceData(this, WeatherUtil.SURVEY_DATA_KEY)?.isNotEmpty() == true) {
            startActivity(Intent(this, MainViewActivity::class.java))
            finish()
        } else {
            initAppBar()
            init()
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

    fun onConfirmClick(v: View) {
        Timber.i("$TAG::onConfirmClick()")
        Toast.makeText(this, getString(R.string.survey_complete), Toast.LENGTH_SHORT).show()
        val surveyData = "$surveySex,$surveyHeat,$surveyStyle"
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