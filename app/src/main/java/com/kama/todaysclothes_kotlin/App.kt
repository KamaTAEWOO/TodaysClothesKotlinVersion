package com.kama.todaysclothes_kotlin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

// hilt 적용
@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(AppDebugTree())
        }
    }

}