package com.kama.core.util

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import java.text.SimpleDateFormat
import java.util.Date

object WeatherUtil {

    private val TAG = "@@EduforallUtil"

    private const val SHARED_PREFS_NAME = "weatherinfo_app_shared_prefs"
    private const val LOGIN_KEY = "login_result"

    // Request Weather Data
    const val PAGE_NO = 1
    const val NUM_OF_ROWS = 1000
    const val DATA_TYPE = "JSON"
    var BASE_DATE = "20240101"
    const val BASE_TIME = "0500"
    const val NX = "55"
    const val NY = "127"

    /**
     ** 금일 날짜
     */
    fun getTodayDate() {
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("yyyyMMdd")
        BASE_DATE = dateFormat.format(currentDate)
    }

    /**
     ** 날짜 format 변경
     */
    fun convertDateFormat(inputDate: String): String {
        val inputDateFormat = SimpleDateFormat("yyyy년 MM월 dd일")
        val outputDateFormat = SimpleDateFormat("yyyy-MM-dd")

        return outputDateFormat.format(inputDateFormat.parse(inputDate))
    }

    /**
     ** Data 저장
     */
    fun saveSharedPreferenceData(context: Context, accessToken: String) {
        val sharedPreferences =
            context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(LOGIN_KEY, accessToken)
        editor.apply()
    }

    /**
     ** Data 가져오기
     */
    fun loadSharedPreferenceData(context: Context): String? {
        val sharedPreferences =
            context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(LOGIN_KEY, null)
    }

    /**
     ** Data 삭제
     */
    fun clearAccessToken(context: Context) {
        val sharedPreferences =
            context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().remove(LOGIN_KEY).apply()
    }

    /**
     * 인터넷 연결 유무
     * */
    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo ?: return false

        return activeNetwork.isConnected
    }
}



















