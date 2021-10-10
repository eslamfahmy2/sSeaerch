package com.fahmy.data.source

import com.fahmy.data.network.ApiInterface
import com.fahmy.data.utils.ResponseState
import com.fahmy.domain.repo.CityRepo
import javax.inject.Inject

class CityRepoImpl @Inject constructor(
    private val api: ApiInterface,
) : CityRepo {

    override suspend fun listCities(query: String) = try {
        val result = api.search(query);
        if (result.isSuccessful) {
            ResponseState.Success(result.body())
        } else {
            ResponseState.Error("empty")
        }
    } catch (e: Exception) {
        ResponseState.Error(e.message)
    }

    override suspend fun listNews(query: String) = try {
        val result = api.searchNews(query);
        if (result.isSuccessful) {
            ResponseState.Success(result.body())
        } else {
            ResponseState.Error("empty")
        }
    } catch (e: Exception) {
        ResponseState.Error(e.message)
    }

}