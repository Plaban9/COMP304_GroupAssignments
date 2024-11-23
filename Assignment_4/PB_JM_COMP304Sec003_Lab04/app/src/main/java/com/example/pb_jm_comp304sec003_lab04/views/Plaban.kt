package com.example.pb_jm_comp304sec003_lab04.views

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.pb_jm_comp304sec003_lab04.views.ui.theme.PB_JM_COMP304Sec003_Lab04Theme
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

class Plaban : ComponentActivity() {

    private var selectedPlacePos: LatLng = LatLng(0.0,0.0)
    private var displayName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PB_JM_COMP304Sec003_Lab04Theme {

                selectedPlacePos = intent.getParcelableExtra("Place_Location", LatLng::class.java)!!
                displayName = intent.getStringExtra("Place_Name").toString()

                MainUI()
            }
        }
    }


    @Preview
    @Composable
    private fun MainUI() {
        ContentUI(innerPadding = PaddingValues(0.dp))
    }

    @Composable
    private fun ContentUI(innerPadding: PaddingValues) {

        val myLocation = LatLng(43.9971, -79.4163) // Toronto

        var camraPosState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(myLocation, 15f)
        }

        val uiSettings by remember {
            mutableStateOf(MapUiSettings(
                mapToolbarEnabled = false,
                zoomControlsEnabled = false,
                compassEnabled = false,
                myLocationButtonEnabled = false,
            ))
        }

        val properties by remember {
            mutableStateOf(
                MapProperties(
                    isBuildingEnabled = true,
                    isMyLocationEnabled = hasLocationPermission(),
            ))
        }

        LaunchedEffect(Unit) {
            when (PackageManager.PERMISSION_GRANTED) {
                // Check if the location permission is already granted
                ContextCompat.checkSelfPermission(applicationContext, android.Manifest.permission.ACCESS_FINE_LOCATION) -> {
                    // We have the location permission (Let's GO!)
                    val fusedLocationClient =
                        LocationServices.getFusedLocationProviderClient(applicationContext)

                    fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                        if (location != null) {
                            // Use the location to get nearby places
                            val latitude = location.latitude
                            val longitude = location.longitude
                            Log.d("Location:", "Latitude: $latitude Longitude:$longitude")
                            camraPosState.position = CameraPosition.fromLatLngZoom(LatLng(latitude, longitude), 10f)
                        }
                    }
                }
            }
        }

        GoogleMap(
            modifier = Modifier.padding(innerPadding),
            cameraPositionState = camraPosState,
            uiSettings = uiSettings,
            properties = properties,
        ) {
            Marker(
                state = rememberMarkerState(key = displayName, position = selectedPlacePos),
                title = displayName,
            )
        }
    }

    private fun Context.hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }
}