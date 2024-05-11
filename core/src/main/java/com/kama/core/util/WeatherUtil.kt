package com.kama.core.util

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.Uri
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

object WeatherUtil {

    private val TAG = "@@EduforallUtil"

    private const val SHARED_PREFS_NAME = "weatherinfo_app_shared_prefs"

    // Request Weather Data
    const val PAGE_NO = 1
    const val NUM_OF_ROWS = 1000
    const val DATA_TYPE = "JSON"
    var BASE_DATE = "20240302"
    const val BASE_TIME = "0500"
    var NX = "55"
    var NY = "127"

    // shared preference key
    const val SURVEY_DATA_KEY = "survey_data_key"

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
    fun saveSharedPreferenceData(context: Context, key: String, accessToken: String) {
        val sharedPreferences =
            context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(key, accessToken)
        editor.apply()
    }

    /**
     ** Data 가져오기
     */
    fun loadSharedPreferenceData(context: Context, key: String): String? {
        val sharedPreferences =
            context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, null)
    }

    /**
     ** Data 삭제
     */
    fun clearAccessToken(context: Context, key: String) {
        val sharedPreferences =
            context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().remove(key).apply()
    }

    /**
     * 인터넷 연결 유무
     * */
    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo ?: return false

        return activeNetwork.isConnected
    }

    /**
     * drawable 리소스를 uri로 변경
     * */
    fun getResourceUri(context: Context, resId: Int): Uri {
        return Uri.parse("android.resource://" + context.packageName + "/" + resId)
    }

    /**
     * 데이터 분리 A;B -> Pair(A, B)
     * */
    fun dataSplit(data: String): Pair<String, String> {
        val splitData = data.split(";")
        return Pair(splitData[0], splitData[1])
    }

    /**
     * 날짜와 시간을 합쳐서 반환 2024-03-02 05:00 -> 20240302;0500
     * */
    fun getCurrentDateTime(): String {
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd;HHmm")
        return currentDateTime.format(formatter)
    }
}



















