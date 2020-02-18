package com.huangjie.weather.ui.city

import com.huangjie.weather.data.City
import com.huangjie.weather.database.CityDao

/**
 * @blame 黄杰
 * @version 2020-02-08 22:53
 * @author huangjie
 */
class CityRepository private constructor(private val cityDao: CityDao) {

    fun searchCity(cityId: Int) = cityDao.load(cityId)

    fun loadCityData(): MutableList<City> {
        return mockCityData()
    }

    private fun mockCityData(): MutableList<City> {
        val mutableList = mutableListOf<City>()
        mutableList.add(City(110, "", "", 123, "成都", "", "", ""))
        return mutableList
    }

    companion object {
        private var instance: CityRepository? = null
        fun getInstance(cityDao: CityDao) = instance ?: synchronized(this) {
            instance ?: CityRepository(cityDao).also { instance = it }
        }
    }

}