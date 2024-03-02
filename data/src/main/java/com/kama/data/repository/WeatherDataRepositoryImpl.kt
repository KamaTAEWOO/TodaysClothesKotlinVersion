package com.kama.data.repository

import com.kama.data.datasource.remote.WeatherDataRemoteDataSource
import com.kama.domain.model.ResponseWeatherDataModel
import com.kama.domain.repository.WeatherDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

// Repository에서 모델 변경해줘야함.
class WeatherDataRepositoryImpl @Inject constructor(
    private val weatherDataRemoteDataSource: WeatherDataRemoteDataSource
) : WeatherDataRepository {

    override fun requestWeatherData(
        pageNo: Int,
        numOfRows: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: String,
        ny: String
    ): Flow<ResponseWeatherDataModel> = weatherDataRemoteDataSource.requestWeatherData(
        pageNo,
        numOfRows,
        dataType,
        baseDate,
        baseTime,
        nx,
        ny
    ).map { it.toModel() }
}