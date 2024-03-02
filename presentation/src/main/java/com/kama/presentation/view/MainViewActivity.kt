package com.kama.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kama.core.base.BaseActivity
import com.kama.presentation.R
import com.kama.presentation.databinding.ActivityMainViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainViewActivity : BaseActivity<ActivityMainViewBinding>() {
    private val TAG = "MainViewActivity::"

    override fun getActivityBinding(): ActivityMainViewBinding =
        ActivityMainViewBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}