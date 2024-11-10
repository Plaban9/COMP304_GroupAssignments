package com.example.pb_jm_comp304sec003_lab03.models

data class WeatherData(
    val location: LocationData,
    val current: Current,
)

data class LocationData(
    val name: String,
    val region: String,
    val country: String
)

data class Current(
    val temp_c: Double,
)
