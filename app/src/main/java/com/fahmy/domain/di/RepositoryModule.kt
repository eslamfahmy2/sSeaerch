package com.fahmy.domain.di

import com.fahmy.data.network.ApiInterface
import com.fahmy.data.source.CityRepoImpl
import com.fahmy.domain.repo.CityRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Singleton
    @Provides
    fun provideCityRepository(
        api: ApiInterface,
    ): CityRepo {
        return CityRepoImpl(api)
    }

}