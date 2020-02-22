package com.huangjie.weather.repository

import com.huangjie.weather.data.Weather
import com.huangjie.weather.http.HttpClientManager
import com.huangjie.weather.utils.LogUtils
import kotlinx.coroutines.*
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


    suspend fun loadWeatherDataAsyn(): Deferred<Weather> {
        return HttpClientManager.httpclient.loadWeather()
    }
}