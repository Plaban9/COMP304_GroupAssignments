package com.example.pb_jm_comp304sec003_lab04.views

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.pb_jm_comp304sec003_lab04.R
import com.example.pb_jm_comp304sec003_lab04.ui.theme.PB_JM_COMP304Sec003_Lab04Theme
import com.google.android.libraries.places.api.Places

class Main : ComponentActivity() {
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!Places.isInitialized()) {
            Places.initialize(applicationContext, getString(R.string.google_maps_api_key))
        }

        enableEdgeToEdge()
        setContent {
            PB_JM_COMP304Sec003_Lab04Theme {

                // Planned to use for showing nearby places using PlacesAPI but its a paid service; so, we need to discard the idea for now
                 AskForLocationPermission()

                MainUI()
            }
        }
    }

    @Preview
    @Composable
    private fun MainUI() {
        Scaffold (
            topBar = { TopAppBarUI() },
            //bottomBar = { BottomAppBarUI() }
        ) { innerPadding ->
            ContentUI(innerPadding = innerPadding)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun TopAppBarUI() {
        TopAppBar(
            title = { Text(text = "Interesting Places 📍") },
            colors = TopAppBarDefaults.topAppBarColors(
                titleContentColor = MaterialTheme.colorScheme.primary,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            )
        )
    }

    @Composable
    private fun BottomAppBarUI() {
        BottomAppBar(
            actions = {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.List, contentDescription = "")
                    }

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Favorite, contentDescription = "")
                    }

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.history),
                            contentDescription = ""
                        )
                    }
                }
            }
        )
    }

    @Composable
    private fun ContentUI(innerPadding: PaddingValues) {
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            contentPadding = PaddingValues(10.dp),
            userScrollEnabled = true,
        ) {
            item { CardUI(painterResource(id = R.drawable.restaurant), placeType = "Restaurant") }
            item { CardUI(painterResource(id = R.drawable.local_cafe), placeType = "Cafe") }
            item { CardUI(painterResource(id = R.drawable.hotel), placeType = "Hotel") }
            item { CardUI(painterResource(id = R.drawable.local_gas_station), placeType = "Gas Station") }
            item { CardUI(painterResource(id = R.drawable.local_grocery_store), placeType = "Grocery") }
        }
    }

    @Composable
    private fun CardUI(painter: Painter, placeType: String) {
        ElevatedCard(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            onClick = { gotoListActivity(this@Main, placeType) },
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary,
            ),
        ) {
            // Card Image (Will be replaced with AsyncImage later on)
            Icon(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(75.dp),
                painter = painter,
                contentDescription = placeType,
            )

            // Card Text
            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                text = placeType,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSecondary,
                textAlign = TextAlign.Center,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Default,
            )
        }
    }

    private fun gotoListActivity(context: Context, placeType: String) {
        val intent = Intent(context, Jaydeep::class.java)
        intent.putExtra("PlaceType", placeType)
        context.startActivity(intent)
    }

    @Composable
    private fun AskForLocationPermission() {

        // Handle permission requests for accessing fine location
        val permissionLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                // Fetch the user's location and update the camera if permission is granted
                //mapViewModel.fetchUserLocation(context, fusedLocationClient)
            } else {
                // Handle the case when permission is denied
                //Timber.e("Location permission was denied by the user.")
            }
        }

        // Request the location permission when the composable is launched
        LaunchedEffect(Unit) {
            when (PackageManager.PERMISSION_GRANTED) {
                // Check if the location permission is already granted
                ContextCompat.checkSelfPermission(
                    applicationContext,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ) -> {
                    // We have the location permission (Let's GO!)
                }
                else -> {
                    // Location permission popup showed (please give permission when asked!)
                    permissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
                }
            }
        }
    }

}
