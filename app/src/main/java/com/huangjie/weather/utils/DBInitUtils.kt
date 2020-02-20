package com.huangjie.weather.utils

import android.content.Context
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.huangjie.weather.constants.CITY_DATABASE_NAME
import com.huangjie.weather.global.GlobalApplication
import com.huangjie.weather.workers.InitDataBaseWorker
import java.io.File

object DBInitUtils {

    fun initDB(context: Context) {

        val dbFile = File(
            GlobalApplication.context.getDatabasePath(
                CITY_DATABASE_NAME
            ).absolutePath
        )

        if (!dbFile.exists()) {
            val request =
                OneTimeWorkRequest.Builder(InitDataBaseWorker::class.java).build()
            WorkManager.getInstance(context).enqueue(request)

        }
    }
}