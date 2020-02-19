package com.huangjie.weather.global

import android.app.Application
import android.content.Context
import com.huangjie.weather.utils.DBInitUtils

/**
 * @blame 黄杰
 * @version 2020-02-02 00:05
 * @author huangjie
 */
class GlobalApplication : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        DBInitUtils.initDB(context)
    }


}