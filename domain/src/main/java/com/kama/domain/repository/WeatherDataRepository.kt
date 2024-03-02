package com.kama.domain.repository

import com.kama.domain.model.ResponseWeatherDataModel
import kotlinx.coroutines.flow.Flow

interface WeatherDataRepository {

    fun requestWeatherData(
        pageNo: Int,
        numOfRows: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: String,
        ny: String
    ): Flow<ResponseWeatherDataModel>
}