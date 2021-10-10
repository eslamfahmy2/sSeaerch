package com.fahmy.domain.di


import com.fahmy.domain.mapper.CityDtoMapper
import com.fahmy.domain.repo.CityRepo
import com.fahmy.domain.useCase.SearchCitiesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Singleton
    @Provides
    fun provideSingInUseCase(
        repository: CityRepo,
        mapperModule: CityDtoMapper,
    ) = SearchCitiesUseCase(repo = repository, mapper = mapperModule)


}