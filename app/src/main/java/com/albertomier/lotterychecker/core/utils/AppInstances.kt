package com.albertomier.lotterychecker.core.utils

import com.albertomier.lotterychecker.LotteryCheckerApp
import com.albertomier.lotterychecker.core.SharedPreferenceUtils

object AppInstances {
    fun getSharedPreferencesInstance(): SharedPreferenceUtils {
        return if (LotteryCheckerApp.sharedPreferenceUtils == null) {
            LotteryCheckerApp.sharedPreferenceUtils = SharedPreferenceUtils()
            LotteryCheckerApp.sharedPreferenceUtils!!
        } else {
            LotteryCheckerApp.sharedPreferenceUtils!!
        }
    }
}