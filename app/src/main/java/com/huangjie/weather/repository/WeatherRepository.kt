package com.huangjie.weather.repository

import com.huangjie.weather.data.Weather
import com.huangjie.weather.http.HttpClientManager
import com.huangjie.weather.utils.LogUtils
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


    fun loadWeatherData() {
        HttpClientManager.httpclient.loadWeather().enqueue(object : Callback<Weather> {
            override fun onFailure(call: Call<Weather>, t: Throwable) {

            }

            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                LogUtils.error("code " + response.code())
                LogUtils.error(response.body().toString())
            }


        })
    }
}