package com.kama.presentation.data


// WeatherDataEntity 클래스에 equals 및 hashCode 메서드 구현
data class WeatherData(
    val baseDate: String,
    val baseTime: String,
    val category: String,
    val fcstDate: String,
    val fcstTime: String,
    val fcstValue: String,
    val nx: Int,
    val ny: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WeatherData

        if (fcstTime != other.fcstTime) return false

        return true
    }

    override fun hashCode(): Int {
        return fcstTime.hashCode()
    }
}

// MainViewModel 클래스에서 데이터를 그룹화하는 메서드 추가
fun groupWeatherDataByFcstTime(weatherDataList: List<WeatherData>): Map<String, List<WeatherData>> {
    return weatherDataList.groupBy { it.fcstTime }
}

