package com.albertomier.lotterychecker.core.utils

import com.albertomier.lotterychecker.core.utils.AppConstants.PREF_MODE
import com.albertomier.lotterychecker.core.utils.AppConstants.PREF_THEME_COLOR
import com.albertomier.lotterychecker.core.utils.AppInstances.getSharedPreferencesInstance
import java.io.Serializable

data class AppThemeState(
    var darkTheme: Boolean = getSharedPreferencesInstance().getBooleanValue(PREF_MODE),
    var pallet: ColorPallet = ColorPallet.valueOf(
        getSharedPreferencesInstance().getStringValue(
            PREF_THEME_COLOR,
            "RED"
        )
    )
) : Serializable