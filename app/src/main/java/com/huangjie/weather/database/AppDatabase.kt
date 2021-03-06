package com.huangjie.weather.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.huangjie.weather.constants.CITY_DATABASE_NAME
import com.huangjie.weather.data.City

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
                }).build()
        }

    }
}