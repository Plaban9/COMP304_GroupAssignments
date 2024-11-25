package com.example.pb_jm_comp304sec003_lab04.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.pb_jm_comp304sec003_lab04.R
import com.example.pb_jm_comp304sec003_lab04.models.PlaceData
import com.example.pb_jm_comp304sec003_lab04.viewmodels.MapViewModel
import com.example.pb_jm_comp304sec003_lab04.views.ui.theme.PB_JM_COMP304Sec003_Lab04Theme

class Jaydeep : ComponentActivity() {

    private var selectedPlaceType = ""
    private val mapViewModel: MapViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PB_JM_COMP304Sec003_Lab04Theme {

                selectedPlaceType = intent.getStringExtra("PlaceType").toString()

                MainUI()
            }
        }
    }

    @Preview
    @Composable
    private fun MainUI() {
        Scaffold (
            topBar = { TopAppBarUI() },
            bottomBar = { BottomAppBarUI() }
        ) { innerPadding ->
            ContentUI(innerPadding = innerPadding)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun TopAppBarUI() {
        TopAppBar(
            title = { Text(text = "Pick your place 🪧") },
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
                Row (
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
                        Icon(painter = painterResource(id = R.drawable.history), contentDescription = "")
                    }
                }
            }
        )
    }

    @Composable
    private fun ContentUI(innerPadding: PaddingValues) {

        var placesList = emptyList<PlaceData>()
        when(selectedPlaceType) {
            "Restaurant" -> placesList = mapViewModel.getRestaurants()
            "Cafe" -> placesList = mapViewModel.getCafes()
            "Hotel" -> placesList = mapViewModel.getHotels()
            "Gas Station" -> placesList = mapViewModel.getGasStations()
            "Grocery" -> placesList = mapViewModel.getGroceries()
            else -> Text(text = "ERROR: Can't load list")
        }

        LazyColumn (
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            contentPadding = PaddingValues(10.dp),
            userScrollEnabled = true,
        ) {
            items(placesList) { place ->
                CardUI(place)
            }
        }
    }

    @Composable
    private fun CardUI(placeData: PlaceData) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            onClick = { gotoMapActivity(this@Jaydeep, placeData) },
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary,
            ),
        ) {
            // Image loaded from internet for specified category
            AsyncImage(
                model = placeData.imgURL,
                contentDescription = "Image About",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable { gotoMapActivity(this@Jaydeep, placeData) },
            )

            Row (
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Title Text
                Text(
                    modifier = Modifier
                        .padding(5.dp)
                        .padding(start = 10.dp)
                        .fillMaxWidth(.7f),
                    text = placeData.displayName,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                )

                // Distance Text (Can't use because the API is paid)
//                Text(
//                    modifier = Modifier.padding(5.dp),
//                    text = "(100 m)",
//                    style = MaterialTheme.typography.bodySmall,
//                    color = MaterialTheme.colorScheme.onSecondary,
//                )

                // Rating Text
                Text(
                    modifier = Modifier
                        .padding(5.dp)
                        .padding(end = 10.dp)
                        .fillMaxWidth(),
                    text = "⭐ ${placeData.rating}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondary,
                    textAlign = TextAlign.Right,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }

    private fun gotoMapActivity(context: Context, placeData: PlaceData) {
        val intent = Intent(context, Plaban::class.java)
        intent.putExtra("Place_Location", placeData.latLng)
        intent.putExtra("Place_Name", placeData.displayName)
        context.startActivity(intent)
    }
}
