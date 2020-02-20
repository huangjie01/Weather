package com.huangjie.weather.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.huangjie.weather.R
import com.huangjie.weather.constants.CITY_DATABASE_NAME
import com.huangjie.weather.global.GlobalApplication
import com.huangjie.weather.utils.LogUtils
import kotlinx.coroutines.coroutineScope
import java.io.FileOutputStream
import java.lang.Exception

/**
 * @blame 黄杰
 * @version 2020-02-09 17:45
 * @author huangjie
 */

class InitDataBaseWorker(context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result = coroutineScope {

        GlobalApplication.context.resources.openRawResource(R.raw.city).use {
            LogUtils.error("InitDataBaseWorker")
            val dbFile = GlobalApplication.context.getDatabasePath(CITY_DATABASE_NAME)
            if (!dbFile.parentFile.exists()) {
                dbFile.mkdir()
            }

            if (!dbFile.exists()) {
                dbFile.createNewFile()
            }

            val fileOutputStream = FileOutputStream(dbFile)
            try {
                val buffer = ByteArray(it.available())
                it.read(buffer)
                fileOutputStream.write(buffer)
                Result.success()
            } catch (exception: Exception) {
                LogUtils.error(exception.message!!)
                Result.failure()
            } finally {
                it.close()
                fileOutputStream.close()
            }
        }
    }
}