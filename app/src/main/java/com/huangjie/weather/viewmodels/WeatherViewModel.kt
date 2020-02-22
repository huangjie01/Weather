package com.huangjie.weather.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.huangjie.weather.data.Weather
import com.huangjie.weather.repository.WeatherRepository
import kotlinx.coroutines.*

class WeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    val weather: MutableLiveData<Weather> = MutableLiveData()

    fun loadWeatherData() {
        CoroutineScope(Dispatchers.Main).launch {
            weather.postValue(loadData())
        }
    }

    private suspend fun loadData(): Weather {
        val weather = withContext(Dispatchers.IO) {
            weatherRepository.loadWeatherDataAsyn()
        }
        return weather.await()
    }
}