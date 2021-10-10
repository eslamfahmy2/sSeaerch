package com.fahmy.domain.useCase

import com.fahmy.data.utils.DataState
import com.fahmy.data.utils.ResponseState
import com.fahmy.domain.mapper.CityDtoMapper
import com.fahmy.domain.model.City
import com.fahmy.domain.repo.CityRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchCitiesUseCase @Inject constructor(
    private val repo: CityRepo,
    private val mapper: CityDtoMapper,
) {
    suspend operator fun invoke(query: String) = flow<DataState<List<City>>> {
        try {
            when (val response = repo.listNews(query)) {
                is ResponseState.Error -> {
                    emit(DataState.Error(response.message))
                }
                is ResponseState.Success -> {
                    val news = response.data?.articles ?: listOf()

                    val result = mapper.toDomainList(news)

                    emit(DataState.Success(result))
                }
            }
        } catch (e: Exception) {
            emit(DataState.Error(e.message))
        }
    }
}