package com.kama.todaysclothes_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kama.presentation.view.SplashActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity::"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 앱 시작
         * */
        Timber.d("$TAG::앱 시작")
        startActivity(Intent(this, SplashActivity::class.java))
    }
}