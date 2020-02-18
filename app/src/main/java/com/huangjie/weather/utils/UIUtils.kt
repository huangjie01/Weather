package com.huangjie.weather.utils

import android.app.Application
import android.content.ComponentCallbacks
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.annotations.NotNull

object UIUtils {

    private var sNonCompatDensity: Float = 0f
    private var sNonCompatScaleDensity: Float = 0f


    fun setCustomDensity(@NotNull activity: AppCompatActivity, application: Application) {

        val displayMetrics = application.resources.displayMetrics

        if (sNonCompatDensity==0f){
            sNonCompatDensity=displayMetrics.density
            sNonCompatScaleDensity=displayMetrics.scaledDensity
            application.registerComponentCallbacks(object : ComponentCallbacks {
                override fun onLowMemory() {
                }

                override fun onConfigurationChanged(newConfig: Configuration) {
                    if (newConfig.fontScale>0){
                        sNonCompatScaleDensity=application.resources.displayMetrics.scaledDensity

                    }
                }
            })
        }

        val targetDensity = (displayMetrics.widthPixels / 360).toFloat()
        val targetDensityDpi = (160 * targetDensity).toInt()

        val scaleTargetDensity =
            targetDensity * (sNonCompatScaleDensity / sNonCompatDensity)

        displayMetrics.density = targetDensity
        displayMetrics.scaledDensity = scaleTargetDensity
        displayMetrics.densityDpi = targetDensityDpi

        val activityDisplayMetrics = activity.resources.displayMetrics

        activityDisplayMetrics.density = targetDensity
        activityDisplayMetrics.scaledDensity = scaleTargetDensity
        activityDisplayMetrics.densityDpi = targetDensityDpi


    }
}