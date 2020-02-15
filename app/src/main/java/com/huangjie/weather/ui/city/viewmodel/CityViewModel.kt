package com.huangjie.weather.ui.city.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.huangjie.weather.data.City
import com.huangjie.weather.ui.city.CityRepository

/**
 * @blame 黄杰
 * @version 2020-02-02 23:46
 * @author huangjie
 */
class CityViewModel internal constructor(cityRepository: CityRepository) : ViewModel() {


    val cityList: MutableLiveData<List<City>> by lazy {
        MutableLiveData<List<City>>().also {
            cityRepository.loadCityData()
        }
    }

}