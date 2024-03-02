package com.kama.data.datasource.remote

import com.kama.core.network.reponse.ResponseWeatherData
import kotlinx.coroutines.flow.Flow

interface WeatherDataRemoteDataSource {

    fun requestWeatherData(
        pageNo: Int,
        numOfRows: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: String,
        ny: String
    ): Flow<ResponseWeatherData>
}