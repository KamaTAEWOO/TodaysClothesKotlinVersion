package com.kama.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kama.presentation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view)
    }
}