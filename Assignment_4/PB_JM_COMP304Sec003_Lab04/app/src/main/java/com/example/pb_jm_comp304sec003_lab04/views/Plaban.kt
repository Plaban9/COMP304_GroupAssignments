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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.pb_jm_comp304sec003_lab04.R
import com.example.pb_jm_comp304sec003_lab04.views.ui.theme.PB_JM_COMP304Sec003_Lab04Theme
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import kotlinx.coroutines.launch

class Plaban : ComponentActivity() {

    private var selectedPlacePos: LatLng = LatLng(0.0,0.0)
    private var myPos: LatLng = LatLng(0.0,0.0)
    private var displayName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PB_JM_COMP304Sec003_Lab04Theme {

                extractDataFromIntent()

                GetMyCurrentPosition()

                MainUI()
            }
        }
    }

    private fun extractDataFromIntent() {
        selectedPlacePos = intent.getParcelableExtra("Place_Location", LatLng::class.java)!!
        displayName = intent.getStringExtra("Place_Name").toString()
    }

    @Composable
    private fun GetMyCurrentPosition() {
        LaunchedEffect(Unit) {
            when (PackageManager.PERMISSION_GRANTED) {
                // Check if the location permission is already granted
                ContextCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) -> {
                    // We have the location permission (Let's GO!)
                    val fusedLocationClient =
                        LocationServices.getFusedLocationProviderClient(applicationContext)

                    fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                        if (location != null) {
                            // Use the location to get nearby places
                            val latitude = location.latitude
                            val longitude = location.longitude
                            Log.d("Location:", "Latitude: $latitude Longitude: $longitude")
                            myPos = LatLng(latitude, longitude)
                        }
                    }
                }
            }
        }
    }


    @Preview
    @Composable
    private fun MainUI() {
        ContentUI(PaddingValues(0.dp))
    }

    @Composable
    private fun ContentUI(innerPadding: PaddingValues) {

        val isMyLocationAvailable = hasLocationPermission()
        val coroutineForCallbacks = rememberCoroutineScope()
        val cameraPosState = rememberCameraPositionState { position = CameraPosition.fromLatLngZoom(selectedPlacePos, 15f) }
        val properties = remember { MapProperties(isBuildingEnabled = true, isMyLocationEnabled = isMyLocationAvailable) }
        val uiSettings = remember { MapUiSettings(mapToolbarEnabled = false, zoomControlsEnabled = false, compassEnabled = false, myLocationButtonEnabled = false) }

        GoogleMap(
            modifier = Modifier.padding(innerPadding),
            cameraPositionState = cameraPosState,
            uiSettings = uiSettings,
            properties = properties,
        ) {
            Marker(
                state = rememberMarkerState(key = displayName, position = selectedPlacePos),
                title = displayName,
            )
        }

        MapInteractableButtions(isMyLocationAvailable = isMyLocationAvailable) {
            coroutineForCallbacks.launch {
                cameraPosState.animate(CameraUpdateFactory.newLatLng(it), 2000)
            }
        }
    }

    @Composable
    private fun MapInteractableButtions(isMyLocationAvailable: Boolean, onFabClicked: (LatLng) -> Unit) {
        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopEnd,
        ) {
            if (isMyLocationAvailable) {
                SmallFloatingActionButton(
                    onClick = { onFabClicked(myPos) },
                    modifier = Modifier.padding(top = 50.dp, end = 10.dp),
                    shape = CircleShape,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.my_location),
                        contentDescription = "Re-Center"
                    )
                }
            }

            SmallFloatingActionButton(
                onClick = { onFabClicked(selectedPlacePos) },
                modifier = Modifier.padding(top = 100.dp, end = 10.dp),
                shape = CircleShape,
            ) {
                Icon(imageVector = Icons.Rounded.LocationOn, contentDescription = "Re-Center")
            }
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