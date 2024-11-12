package com.example.pb_jm_comp304sec003_lab03.views.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.pb_jm_comp304sec003_lab03.Navigation.NavDestination
import com.example.pb_jm_comp304sec003_lab03.viewmodels.WeatherDataViewModel
import com.example.pb_jm_comp304sec003_lab03.views.WeatherCard

@Composable
fun HomeScreen(navController: NavController, viewModel: WeatherDataViewModel)
{
    MainUI(navController = navController, viewModel = viewModel)
}

@Composable
private fun MainUI(navController: NavController, viewModel: WeatherDataViewModel)
{
    Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopAppBarUI(navController = navController) }
    ) { innerPadding ->
        ContentUI(innerPadding, viewModel)
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopAppBarUI(navController: NavController)
{
    TopAppBar(
            title = { Text(text = "Weather App 🌦️") },
            colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            actions = {
                IconButton(
                        onClick = { searchBarUI(navController = navController) }
                ) {
                    Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search City",
                    )
                }
            }
    )
}

@Composable
private fun ContentUI(innerPaddingValues: PaddingValues, viewModel: WeatherDataViewModel)
{
    viewModel.fetchCityWeatherData(city = "Toronto")

    val weatherData by viewModel.weatherData.observeAsState(initial = null)

    if (weatherData == null)
    {
        Text(text = "Loading...")
    }
    else
    {
        LazyColumn(
                modifier = Modifier.padding(innerPaddingValues),
        ) {
//                items(weatherDataList) { weatherData ->
//                    WeatherCard(weatherData)
//                }
            item {
                WeatherCard(weatherData = weatherData!!)
                Text(text = weatherData.toString())
            }
        }
    }
}

private fun searchBarUI(navController: NavController)
{
    navController.navigate(NavDestination.SearchScreen.route)
}
