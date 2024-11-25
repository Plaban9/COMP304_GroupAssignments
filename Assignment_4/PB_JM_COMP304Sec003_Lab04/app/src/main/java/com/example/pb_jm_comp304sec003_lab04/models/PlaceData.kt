package com.example.pb_jm_comp304sec003_lab04.models

import androidx.annotation.DrawableRes
import com.google.android.gms.maps.model.LatLng

data class PlaceData(
    val latLng: LatLng,
    val displayName: String,
    @DrawableRes val placeImg: Int,
    val rating: Float,
    val imgURL: String = "",
)
