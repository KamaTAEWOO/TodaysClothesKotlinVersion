package com.kama.presentation.view

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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
    private val PERMISSION_REQUEST_CODE = 1001

    override fun getActivityBinding(): ActivityMainViewBinding =
        ActivityMainViewBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
        initBottomNavigation()
    }

    private fun init() {
        requestStoragePermission()
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

    private fun requestStoragePermission() {
        val permission = Manifest.permission.READ_EXTERNAL_STORAGE
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
            // 권한이 이미 허용되어 있음
            // 여기에서 이미지에 접근하는 로직을 수행할 수 있음
            Timber.d("$TAG::requestStoragePermission() 권한 허용됨")
            WeatherUtil.getTodayDate()
            getWeatherData()
        } else {
            // 권한이 없으므로 사용자에게 권한 요청
            Timber.d("$TAG::requestStoragePermission() 권한 요청됨")
            ActivityCompat.requestPermissions(this, arrayOf(permission), PERMISSION_REQUEST_CODE)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 권한이 허용됨
                // 여기에서 이미지에 접근하는 로직을 수행할 수 있음
                Timber.d("$TAG::onRequestPermissionsResult() 권한 허용됨")
            } else {
                // 권한이 거부됨
                // 권한 거부에 대한 처리를 수행할 수 있음
                Timber.d("$TAG::onRequestPermissionsResult() 권한 거부됨")
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {}
}