package com.kama.core.network.reponse

import com.kama.domain.model.ResponseWeatherDataModel

data class ResponseWeatherData (
    var response: Response
) {
    fun toModel() = ResponseWeatherDataModel(
        response = response.toModel()
    )

    data class Response(
        val header: Header,
        val body: Body
    ) {
        fun toModel() = ResponseWeatherDataModel.Response(
            header = header.toModel(),
            body = body.toModel()
        )
    }

    data class Header(
        val resultCode: String,
        val resultMsg: String
    ) {
        fun toModel() = ResponseWeatherDataModel.Header(
            resultCode = resultCode,
            resultMsg = resultMsg
        )
    }

    data class Body(
        val dataType: String,
        val items: Items
    ) {
        fun toModel() = ResponseWeatherDataModel.Body(
            dataType = dataType,
            items = items.toModel()
        )
    }

    data class Items(
        val item: List<Item>
    ) {
        fun toModel() = ResponseWeatherDataModel.Items(
            item = item.map { it.toModel() }
        )
    }

    data class Item(
        val baseDate: String,
        val baseTime: String,
        val category: String,
        val fcstDate : String,
        val fcstTime : String,
        val fcstValue : String,
        val nx : Int,
        val ny : Int
    ) {
        fun toModel() = ResponseWeatherDataModel.Item(
            baseDate = baseDate,
            baseTime = baseTime,
            category = category,
            fcstDate = fcstDate,
            fcstTime = fcstTime,
            fcstValue = fcstValue,
            nx = nx,
            ny = ny
        )
    }
}