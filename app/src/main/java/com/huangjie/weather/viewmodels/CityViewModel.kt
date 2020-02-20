package com.huangjie.weather.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.huangjie.weather.data.City
import com.huangjie.weather.repository.CityRepository

/**
 * @blame 黄杰
 * @version 2020-02-02 23:46
 * @author huangjie
 */
class CityViewModel(private val cityRepository: CityRepository) : ViewModel() {

    val cityList: MutableLiveData<List<City>> = MutableLiveData()

    /*by lazy {
MutableLiveData<List<City>>().also {
     cityRepository.loadCityData()
}*/

    fun loadData() {
        cityList.postValue(cityRepository.loadCityData())
    }

}