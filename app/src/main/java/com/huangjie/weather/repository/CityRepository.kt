package com.huangjie.weather.repository

import com.huangjie.weather.data.City
import com.huangjie.weather.database.CityDao
import com.huangjie.weather.utils.LogUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * @blame 黄杰
 * @version 2020-02-08 22:53
 * @author huangjie
 */
class CityRepository private constructor(private val cityDao: CityDao) {

    fun searchCity(cityId: Int) = runBlocking {
        cityDao.load(cityId)
    }

    fun loadCityData(): MutableList<City> = runBlocking {
        withContext(Dispatchers.IO) {
            LogUtils.error(Thread.currentThread().name)
            cityDao.loadAllCity()
        }
    }

    private fun mockCityData(): MutableList<City> {
        val mutableList = mutableListOf<City>()
        mutableList.add(City(110, "", "", 123, "成都", "", "", ""))
        mutableList.add(City(120, "", "", 124, "彭山", "", "", ""))
        mutableList.add(City(130, "", "", 125, "上海", "", "", ""))
        mutableList.add(City(140, "", "", 126, "北京", "", "", ""))
        mutableList.add(City(150, "", "", 127, "西安", "", "", ""))

        return mutableList
    }

    companion object {
        private var instance: CityRepository? = null
        fun getInstance(cityDao: CityDao) = instance
            ?: synchronized(this) {
                instance
                    ?: CityRepository(cityDao).also { instance = it }
            }
    }

}