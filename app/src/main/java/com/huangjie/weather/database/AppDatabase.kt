package com.huangjie.weather.database

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.huangjie.weather.constants.CITY_DATABASE_NAME
import com.huangjie.weather.data.City
import com.huangjie.weather.global.GlobalApplication
import com.huangjie.weather.workers.InitDataBaseWorker
import java.io.File

/**
 * @blame 黄杰
 * @version 2020-02-09 12:37
 * @author huangjie
 */

@Database(entities = [City::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, CITY_DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {

                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
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
                }).build()
        }

    }
}