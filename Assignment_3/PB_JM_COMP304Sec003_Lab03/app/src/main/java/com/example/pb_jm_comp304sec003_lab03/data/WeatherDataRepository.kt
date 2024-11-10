package com.example.pb_jm_comp304sec003_lab03.data

import android.util.Log
import com.example.pb_jm_comp304sec003_lab03.models.WeatherData
import com.example.pb_jm_comp304sec003_lab03.services.RetrofitInstance

class WeatherDataRepository {
    private val weatherDataService = RetrofitInstance.weatherService

    suspend fun getWeatherData(city: String): WeatherData {
        val data = weatherDataService.getWeatherData(city)
        Log.d("Weather Data", data.toString())
        return data
    }
}