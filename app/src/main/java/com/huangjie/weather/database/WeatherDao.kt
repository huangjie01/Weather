package com.huangjie.weather.database

import androidx.room.Dao
import com.huangjie.weather.data.Weather


@Dao
interface WeatherDao {

     //@Query("SELECT * from weather where  cityId=cityID")
     suspend fun loadWeather(cityID:Int):Weather
}