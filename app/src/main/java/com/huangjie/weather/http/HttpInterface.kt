package com.huangjie.weather.http

import com.huangjie.weather.data.Weather
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * @blame 黄杰
 * @version 2020-02-02 00:13
 * @author huangjie
 */
interface HttpInterface {
    @GET("https://weatherapi.market.xiaomi.com/wtr-v3/weather/all?latitude=0&longitude=0&isLocated=true&locationKey=weathercn%3A101270101&days=15&appKey=weather20151024&sign=zUFJoAR2ZVrDy1vF3D07&romVersion=7.2.16&appVersion=87&alpha=false&isGlobal=false&device=cancro&modDevice=&locale=zh_cn 或 https://weatherapi.market.xiaomi.com/wtr-v3/weather/all?latitude=110&longitude=112&locationKey=weathercn%3A101010100&days=15&appKey=weather20151024&sign=zUFJoAR2ZVrDy1vF3D07&isGlobal=false&locale=zh_cn")
    suspend fun loadWeather(): Deferred<Weather>
}