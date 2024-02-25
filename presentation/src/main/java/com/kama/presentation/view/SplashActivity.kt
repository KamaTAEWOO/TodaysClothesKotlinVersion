package com.kama.presentation.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.kama.core.base.BaseActivity
import com.kama.presentation.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    private val TAG = "SplashActivity::"

    override fun getActivityBinding(): ActivitySplashBinding =
        ActivitySplashBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 3초 후에 Intent 실행
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MyStyleSurveyActivity::class.java))
            finish()
        }, 3000)
    }

    override fun onBackPressed() {}
}