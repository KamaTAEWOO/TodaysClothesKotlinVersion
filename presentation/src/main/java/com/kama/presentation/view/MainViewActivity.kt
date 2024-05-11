package com.kama.presentation.view

import android.Manifest
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.kama.core.base.BaseActivity
import com.kama.core.util.WeatherUtil
import com.kama.presentation.R
import com.kama.presentation.databinding.ActivityMainViewBinding
import com.kama.presentation.geo.CSVParser
import com.kama.presentation.geo.GpsTracker
import com.kama.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException
import java.util.Locale

@AndroidEntryPoint
class MainViewActivity : BaseActivity<ActivityMainViewBinding>() {
    private val TAG = "MainViewActivity::"

    private val mainViewModel: MainViewModel by viewModels()
    private val PERMISSION_REQUEST_CODE = 1001
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun getActivityBinding(): ActivityMainViewBinding =
        ActivityMainViewBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
        requestPermissions()
        initBottomNavigation()
    }

    private fun requestPermissions() {
        val permissionsToRequest = mutableListOf<String>()

        val locationPermission = Manifest.permission.ACCESS_FINE_LOCATION
        if (ContextCompat.checkSelfPermission(this, locationPermission) != PackageManager.PERMISSION_GRANTED) {
            permissionsToRequest.add(locationPermission)
        }

        val storagePermission = Manifest.permission.READ_EXTERNAL_STORAGE
        if (ContextCompat.checkSelfPermission(this, storagePermission) != PackageManager.PERMISSION_GRANTED) {
            permissionsToRequest.add(storagePermission)
        }

        if (permissionsToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), PERMISSION_REQUEST_CODE)
        } else {
            // 모든 권한이 이미 허용되어 있음
            onPermissionsGranted()
        }
    }

    private fun init() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        CSVParser(this).parseCSV("geo_info.csv")
    }

    private fun initBottomNavigation() {
        Timber.i("initBottomNavigation()")
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    private fun onPermissionsGranted() {
        Timber.d("All permissions granted")
        WeatherUtil.getTodayDate() // 금일 날짜
        getLastLocation() // nx, ny 좌표값을 얻기 위한 위치 정보 획득
        getWeatherData()
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

    private fun getLastLocation() {
        Timber.i("$TAG::getLastLocation()")
        val gpsTracker = GpsTracker(this)

        val latitude = gpsTracker.getLatitude()
        val longitude = gpsTracker.getLongitude()
        Timber.d("$TAG::getLastLocation() latitude: $latitude, longitude: $longitude")

        val address = gpsTracker.getCurrentAddress(latitude, longitude)
        Timber.d("$TAG::getLastLocation() address: $address")

        // 현재 주소의 nx와 ny를 csv에서 찾기
        val addressData = address.split(" ").toTypedArray()
        myLocation = addressData[1] + " " + addressData[2] + " " + addressData[3]
        val dong = addressData[3].dropLast(1)
        for (data in CSVParser.data) {
            if (data.address1 == addressData[1]
                && data.address2 == addressData[2]
                && data.address3.contains(dong)) {
                WeatherUtil.NX = data.nx.toString()
                WeatherUtil.NY = data.ny.toString()
                Timber.d("$TAG::getLastLocation() nx: ${WeatherUtil.NX}, ny: ${WeatherUtil.NY}")
                break
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                onPermissionsGranted()
            } else {
                Timber.e("Permissions denied")
            }
        }
    }

    fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(com.kama.design.R.menu.option, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                com.kama.design.R.id.option_modify_servey -> {
                    Timber.i("$TAG::onOptionsItemSelected() option_modify_servey")
                    true
                }
                com.kama.design.R.id.option_close -> {
                    Timber.i("$TAG::onOptionsItemSelected() option_close")
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Clean up resources
    }

    companion object {
        var myLocation = "My Location"
    }
}
