package com.kama.domain.usecase

import com.kama.domain.model.ResponseWeatherDataModel
import com.kama.domain.repository.WeatherDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherDataUseCase @Inject constructor(
    private val weatherDataRepository: WeatherDataRepository
) {

    operator fun invoke(
        pageNo: Int,
        numOfRows: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: String,
        ny: String
    ): Flow<ResponseWeatherDataModel> =
        weatherDataRepository.requestWeatherData(
            pageNo,
            numOfRows,
            dataType,
            baseDate,
            baseTime,
            nx,
            ny
        )
}