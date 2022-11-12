package com.learner.codereducer.utils

import android.os.Build

object AndroidUtils {
    fun userPhoneVersion() = Build.VERSION.SDK_INT
    fun isAndroidVersionQ(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q
    }

    /**@param versionCode Only from [Build.VERSION_CODES]*/
    fun isAndroidVersion(versionCode: Int) = Build.VERSION.SDK_INT >= versionCode
}