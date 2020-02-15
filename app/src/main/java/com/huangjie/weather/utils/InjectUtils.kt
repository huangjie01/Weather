package com.huangjie.weather.utils

import android.content.Context
import com.huangjie.weather.database.AppDatabase
import com.huangjie.weather.ui.city.CityRepository
import com.huangjie.weather.viewmodels.CityViewModelFactory

/**
 * @blame 黄杰
 * @version 2020-02-09 12:30
 * @author huangjie
 */

object InjectUtils {

    private fun getCityRepository(context: Context): CityRepository {
        return CityRepository.getInstance(AppDatabase.getInstance(context).cityDao())
    }


    fun providerCityViewModelFactory(
        context: Context
    ): CityViewModelFactory {
        return CityViewModelFactory(getCityRepository(context))
    }
}