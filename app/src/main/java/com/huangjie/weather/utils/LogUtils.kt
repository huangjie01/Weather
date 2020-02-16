package com.huangjie.weather.utils

import android.util.Log


object LogUtils {
    private const val TAG = "Weather"
    private const val debug = true


    fun error(text: String) {
        if (debug) {
            Log.e(TAG, text)
        }
    }
}