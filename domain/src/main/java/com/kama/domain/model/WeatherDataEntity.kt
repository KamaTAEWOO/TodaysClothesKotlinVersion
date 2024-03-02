package com.kama.domain.model

data class WeatherDataEntity(
    val baseDate: String,
    val baseTime: String,
    val category: String,
    val fcstDate : String,
    val fcstTime : String,
    val fcstValue : String,
    val nx : Int,
    val ny : Int
)