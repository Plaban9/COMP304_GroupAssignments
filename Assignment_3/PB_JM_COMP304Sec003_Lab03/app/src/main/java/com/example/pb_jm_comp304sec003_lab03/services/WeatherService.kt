package com.example.pb_jm_comp304sec003_lab03.services

import com.example.pb_jm_comp304sec003_lab03.models.WeatherData
import retrofit2.http.GET

interface WeatherService {
    @GET("current.json?key=f2c7c09f8c3d472b9d2181802241011&q=Toronto&aqi=yes")
    suspend fun getWeatherData() : WeatherData
}