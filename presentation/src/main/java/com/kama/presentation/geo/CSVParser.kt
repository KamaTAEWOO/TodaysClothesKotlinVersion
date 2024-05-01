package com.kama.presentation.geo

import android.content.Context
import com.kama.presentation.data.GeoData
import java.io.BufferedReader
import java.io.InputStreamReader

class CSVParser(private val context: Context) {

    fun parseCSV(fileName: String) {
        try {
            val inputStream = context.assets.open(fileName)
            val reader = BufferedReader(InputStreamReader(inputStream))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                // CSV 파일을 쉼표(,)로 분리하여 데이터 추출
                val rowData = line?.split(",")?.toTypedArray()
                if (rowData != null) {
                    data.add(GeoData(rowData[2], rowData[3], rowData[4], rowData[5].toInt(), rowData[6].toInt()))
                }
            }
            reader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        val data = mutableListOf<GeoData>()
    }
}
