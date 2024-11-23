package com.example.pb_jm_comp304sec003_lab04.viewmodels

import androidx.lifecycle.ViewModel
import com.example.pb_jm_comp304sec003_lab04.data.PlacesRepository
import com.example.pb_jm_comp304sec003_lab04.models.PlaceData

class MapViewModel: ViewModel() {
    private val repository = PlacesRepository()

    fun getRestaurants() : List<PlaceData> { return repository.getRestaurants() }
    fun getCafes() : List<PlaceData> { return repository.getCafes() }
    fun getHotels() : List<PlaceData> { return repository.getHotels() }
    fun getGroceries() : List<PlaceData> { return repository.getGroceries() }
    fun getGasStations() : List<PlaceData> { return repository.getGasStations() }
}