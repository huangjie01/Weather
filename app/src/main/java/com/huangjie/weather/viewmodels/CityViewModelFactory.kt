package com.huangjie.weather.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.huangjie.weather.repository.CityRepository

/**
 * @blame 黄杰
 * @version 2020-02-09 21:18
 * @author huangjie
 */

class CityViewModelFactory(private val cityRepository: CityRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CityViewModel(cityRepository) as T
    }
}