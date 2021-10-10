package com.fahmy.domain.repo

import com.fahmy.data.dto.news.ResponseDto
import com.fahmy.data.utils.ResponseState
import io.reactivex.Observable

interface CityRepo {

    suspend fun listCities(query: String): ResponseState<ResponseDto?>

    suspend fun listNews(query: String): ResponseState<ResponseDto?>

    suspend fun listNewsRx(query: String): Observable<ResponseDto>
}