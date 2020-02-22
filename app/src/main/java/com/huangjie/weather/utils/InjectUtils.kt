package com.huangjie.weather.utils

import android.content.Context
import com.huangjie.weather.database.AppDatabase
import com.huangjie.weather.repository.CityRepository
import com.huangjie.weather.repository.WeatherRepository
import com.huangjie.weather.viewmodels.CityViewModelFactory
import com.huangjie.weather.viewmodels.WeatherViewModel

/**
 * @blame 黄杰
 * @version 2020-02-09 12:30
 * @author huangjie
 */

object InjectUtils {

    private fun getCityRepository(context: Context): CityRepository {
        return CityRepository.getInstance(AppDatabase.getInstance(context).cityDao())
    }

    private fun getWeatherRepository(context: Context): WeatherRepository {
        return WeatherRepository.getInstance()
    }

    fun providerCityViewModelFactory(
        context: Context
    ): CityViewModelFactory {
        return CityViewModelFactory(getCityRepository(context))
    }

    fun providerWeatherModel(context: Context): WeatherViewModel {

        return WeatherViewModel(getWeatherRepository(context))
    }
}