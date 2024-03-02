package com.kama.data.di

import com.kama.data.datasource.remote.WeatherDataRemoteDataSource
import com.kama.data.datasource.remote.WeatherDataRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    @Singleton
    fun bindsWeatherDataRemoteDataSource(
        weatherDataRemoteDataSourceImpl: WeatherDataRemoteDataSourceImpl
    ): WeatherDataRemoteDataSource

}