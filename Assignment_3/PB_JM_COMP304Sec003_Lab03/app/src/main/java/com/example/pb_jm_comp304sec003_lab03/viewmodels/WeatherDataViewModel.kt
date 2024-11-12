package com.example.pb_jm_comp304sec003_lab03.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pb_jm_comp304sec003_lab03.data.WeatherDataRepository
import com.example.pb_jm_comp304sec003_lab03.models.CityData
import com.example.pb_jm_comp304sec003_lab03.models.WeatherData
import kotlinx.coroutines.launch

class WeatherDataViewModel : ViewModel()
{
    private val repository = WeatherDataRepository()

    private val _weatherData = MutableLiveData<WeatherData>()
    val weatherData: LiveData<WeatherData> = _weatherData

    private val _cityList = MutableLiveData<List<CityData>>()
    val cityList: LiveData<List<CityData>> = _cityList

    fun fetchCityWeatherData(city: String)
    {
        viewModelScope.launch {
            try
            {
                val _data = repository.getCityWeatherData(city)
                _weatherData.value = _data
            }
            catch (e: Exception)
            {
                Log.d("Weather Data Fetch Failed", e.message.toString())
            }
        }
    }

    fun fetchCityList(city: String)
    {
        viewModelScope.launch {
            try
            {
                val _data = repository.getCityList(city)
                _cityList.value = _data
            }
            catch (e: Exception)
            {
                Log.d("City List Fetch Failed", e.message.toString())
            }
        }
    }
}