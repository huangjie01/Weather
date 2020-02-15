package com.huangjie.weather.http.intercept

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @blame 黄杰
 * @version 2020-02-02 00:12
 * @author huangjie
 */
class HttpIntercept : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }

}