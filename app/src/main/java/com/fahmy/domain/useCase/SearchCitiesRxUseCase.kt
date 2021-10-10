package com.fahmy.domain.useCase

import com.fahmy.domain.mapper.CityDtoMapper
import com.fahmy.domain.model.City
import com.fahmy.domain.repo.CityRepo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class SearchCitiesRxUseCase @Inject constructor(
    private val repo: CityRepo,
    private val mapper: CityDtoMapper,
) {
    suspend operator fun invoke(query: String): Observable<City> {
        return repo.listNewsRx(query = query).map {
            mapper.mapToDomainModel(it)
        }.observeOn(AndroidSchedulers.mainThread())

    }
}