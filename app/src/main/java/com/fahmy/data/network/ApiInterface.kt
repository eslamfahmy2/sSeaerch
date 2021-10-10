package com.fahmy.data.network


import com.fahmy.data.dto.news.ResponseDto
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("cities")
    suspend fun search(@Query("namePrefix") namePrefix: String): Response<ResponseDto>

    @GET("everything")
    suspend fun searchNews(@Query("q") q: String): Response<ResponseDto>

    @GET("everything")
    fun searchNewsRx(@Query("q") q: String): Observable<ResponseDto>

}