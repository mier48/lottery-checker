package com.albertomier.lotterychecker

import android.app.Application
import com.albertomier.lotterychecker.core.SharedPreferenceUtils
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LotteryCheckerApp : Application() {

    companion object {
        var sharedPreferenceUtils: SharedPreferenceUtils? = null
        private lateinit var instance: LotteryCheckerApp

        fun getAppInstance(): LotteryCheckerApp {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}