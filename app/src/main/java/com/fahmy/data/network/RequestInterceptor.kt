package com.fahmy.data.network

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val original = chain
            .request().url.newBuilder()
            .addQueryParameter("apiKey", "eed8c595b6d34546b50a7ba474c7a727")
            .build()

        val newRequest = chain
            .request()
            .newBuilder()
            .url(original)
            .build()
        return chain.proceed(newRequest)


        /*
        val original = chain
            .request().headers.newBuilder()
            .add("x-rapidapi-key", "4c76e2c9a8msh7340d42770401ddp1a4bedjsn5c9e28121a06")
            .add("x-rapidapi-host", "wft-geo-db.p.rapidapi.com")
            .build()

        val newRequest = chain
            .request()
            .newBuilder()
            .headers(original)
            .build()
        return chain.proceed(newRequest)
        */
    }
}
