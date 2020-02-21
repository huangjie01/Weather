package com.huangjie.weather.repository

import com.huangjie.weather.data.Weather
import com.huangjie.weather.http.HttpClientManager
import com.huangjie.weather.utils.LogUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WeatherRepository private constructor() {

    companion object {
        private var instance: WeatherRepository? = null
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: WeatherRepository().also { instance = it }
        }
    }


    suspend fun loadWeatherData(): Call<Weather> {
        return HttpClientManager.httpclient.loadWeather()
    }
}