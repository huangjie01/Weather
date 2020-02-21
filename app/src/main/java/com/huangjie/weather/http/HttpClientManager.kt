package com.huangjie.weather.http

import com.huangjie.weather.global.GlobalApplication
import com.huangjie.weather.http.intercept.HttpIntercept
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * @blame 黄杰
 * @version 2020-02-01 23:59
 * @author huangjie
 */

object HttpClientManager {

    private const val cacheSize: Long = 10 * 1024 * 1024
    private val cacheFile: File = File(GlobalApplication.context.cacheDir, "cache")
    private val cache: Cache = Cache(cacheFile, cacheSize)

    private val okHttpclient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpIntercept())
        .cache(cache)
        .connectTimeout(17, TimeUnit.MINUTES)
        .readTimeout(17, TimeUnit.MINUTES)
        .retryOnConnectionFailure(true)
        .build()

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http://gank.io/api/")
        .client(okHttpclient)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val httpclient: HttpInterface = retrofit().create(HttpInterface::class.java)
}