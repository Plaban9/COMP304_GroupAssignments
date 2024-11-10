package com.example.pb_jm_comp304sec003_lab03.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pb_jm_comp304sec003_lab03.data.WeatherDataRepository
import com.example.pb_jm_comp304sec003_lab03.models.WeatherData
import kotlinx.coroutines.launch

class WeatherDataViewModel: ViewModel() {
    private val repository = WeatherDataRepository()

    private val _weatherData = MutableLiveData<WeatherData>()
    val weatherData: LiveData<WeatherData> = _weatherData

    fun fetchWeatherData() {
        viewModelScope.launch {
            try {
                val _data = repository.getWeatherData()
                _weatherData.value = _data
            } catch (e: Exception) {
                Log.d("Weather Data Fetch Failed", e.message.toString())
            }
        }
    }
}