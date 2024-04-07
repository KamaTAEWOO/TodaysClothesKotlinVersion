package com.kama.core.util

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type;

class SharedPreferenceHelper(
    private val context: Context,
    private val fileName: String
) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    }

    // 이미지 URI 리스트를 초기화하고 새로운 리스트를 SharedPreferences에 저장합니다.
    fun saveNewImageList(newImageList: List<Uri>, fileName: String) {
        clearImageList(fileName) // 이미지 URI 리스트 초기화
        saveImageList(newImageList, fileName) // 새로운 이미지 URI 리스트 저장
    }

    // 이미지 URI 리스트를 모두 지웁니다.
    private fun clearImageList(fileName: String) {
        sharedPreferences.edit().remove(fileName).apply()
    }

    // 이미지 URI 리스트를 SharedPreferences에 저장합니다.
    private fun saveImageList(imageList: List<Uri>, fileName: String) {
        val gson = Gson()
        val json = gson.toJson(imageList.drop(1).map { it.toString() }) // 0번째 인덱스를 제외하고 URI를 String으로 변환하여 저장
        sharedPreferences.edit().putString(fileName, json).apply()
    }

    // SharedPreferences에서 이미지 URI 리스트를 가져옵니다.
    fun getImageList(fileName: String): List<Uri> {
        val json = sharedPreferences.getString(fileName, null)
        return if (json != null) {
            val gson = Gson()
            val type = object : TypeToken<List<String>>() {}.type
            gson.fromJson<List<String>>(json, type).map { Uri.parse(it) } // String을 URI로 변환하여 반환
        } else {
            ArrayList()
        }
    }
}