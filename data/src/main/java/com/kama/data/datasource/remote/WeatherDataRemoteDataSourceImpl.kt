package com.kama.data.datasource.remote

import com.kama.core.network.api.WeatherDataService
import com.kama.core.network.reponse.ResponseWeatherData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

class WeatherDataRemoteDataSourceImpl @Inject constructor(
    private val weatherDataService: WeatherDataService
) : WeatherDataRemoteDataSource {
    override fun requestWeatherData(
        pageNo: Int,
        numOfRows: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: String,
        ny: String
    ): Flow<ResponseWeatherData> = flow {
        emit(
            weatherDataService.requestWeatherData(
                pageNo,
                numOfRows,
                dataType,
                baseDate,
                baseTime,
                nx,
                ny
            )
        )
    }
}