package com.kama.presentation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.kama.core.base.BaseActivity
import com.kama.core.util.WeatherUtil
import com.kama.presentation.R
import com.kama.presentation.databinding.ActivityMainViewBinding
import com.kama.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainViewActivity : BaseActivity<ActivityMainViewBinding>() {
    private val TAG = "MainViewActivity::"

    private val mainViewModel: MainViewModel by viewModels()

    override fun getActivityBinding(): ActivityMainViewBinding =
        ActivityMainViewBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
        initBottomNavigation()
    }

    private fun init() {
        WeatherUtil.getTodayDate()
        getWeatherData()
    }

    private fun initBottomNavigation() {
        Timber.i("$TAG::initBottomNavigation()")
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    /**
     * Item(baseDate=20231224, baseTime=0500, category=VVV, fcstDate=20231226, fcstTime=1900, fcstValue=-1.7, nx=55, ny=127)
     * */
    private fun getWeatherData() {
        Timber.i("$TAG::getWeatherData()")

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.requestWeatherData(
                    WeatherUtil.PAGE_NO,
                    WeatherUtil.NUM_OF_ROWS,
                    WeatherUtil.DATA_TYPE,
                    WeatherUtil.BASE_DATE,
                    WeatherUtil.BASE_TIME,
                    WeatherUtil.NX,
                    WeatherUtil.NY
                )
            }
        }
    }

    override fun onBackPressed() {}
}