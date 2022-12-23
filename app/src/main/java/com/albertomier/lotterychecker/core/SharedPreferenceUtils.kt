package com.albertomier.lotterychecker.core

import android.content.Context
import android.content.SharedPreferences
import com.albertomier.lotterychecker.LotteryCheckerApp.Companion.getAppInstance
import com.albertomier.lotterychecker.core.utils.AppConstants.SHARED_NAME

class SharedPreferenceUtils {
    private val sharedPreferences: SharedPreferences = getAppInstance().getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
    private var sharedPreferencesEditor: SharedPreferences.Editor = sharedPreferences.edit()

    init {
        sharedPreferencesEditor.apply()
    }

    fun setValue(key: String, value: Any?) {
        when (value) {
            is Int? -> {
                sharedPreferencesEditor.putInt(key, value!!)
                sharedPreferencesEditor.apply()
            }
            is String? -> {
                sharedPreferencesEditor.putString(key, value!!)
                sharedPreferencesEditor.apply()
            }
            is Boolean? -> {
                sharedPreferencesEditor.putBoolean(key, value!!)
                sharedPreferencesEditor.apply()
            }
        }
    }

    fun getStringValue(key: String, defaultValue: String = ""): String {
        return sharedPreferences.getString(key, defaultValue)!!
    }

    fun getIntValue(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun getBooleanValue(keyFlag: String, defaultValue: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(keyFlag, defaultValue)
    }

    fun removeKey(key: String) {
        sharedPreferencesEditor.remove(key)
        sharedPreferencesEditor.apply()
    }

    fun clear() {
        sharedPreferencesEditor.clear().apply()
    }
}
