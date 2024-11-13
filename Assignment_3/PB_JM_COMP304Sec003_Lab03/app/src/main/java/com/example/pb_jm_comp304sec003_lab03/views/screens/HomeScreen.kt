package com.example.pb_jm_comp304sec003_lab03.views.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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

@Composable
fun HomeScreen(navController: NavController, viewModel: WeatherDataViewModel, cityJsonString: String?)
{
    //TODO: Check JSON Here
    MainUI(navController = navController, viewModel = viewModel)
}

@Composable
fun HomeScreen(navController: NavController, viewModel: WeatherDataViewModel)
{
    MainUI(navController = navController, viewModel = viewModel)
}

@Composable
private fun MainUI(navController: NavController, viewModel: WeatherDataViewModel)
{
    //TODO: Array of Cities
    val test_city = "Toronto"
    Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopAppBarUI(navController = navController) }
    ) { innerPadding ->
        ContentUI(city = test_city, innerPadding, viewModel)
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

//TODO: Custom City
@Composable
private fun ContentUI(city: String, innerPaddingValues: PaddingValues, viewModel: WeatherDataViewModel)
{
    viewModel.fetchCityWeatherData(city = city)
    //Test
//    viewModel.fetchCityWeatherData(city = "Toronto")

    val weatherData by viewModel.weatherData.observeAsState(initial = null)

    //Test
//    viewModel.fetchCityWeatherData(city = "London")
//    val weatherData by viewModel.weatherData.observeAsState(initial = null)
//
//    viewModel.fetchCityWeatherData(city = "New Delhi")
//    val weatherData2 by viewModel.weatherData.observeAsState(initial = null)
//
//    viewModel.fetchCityWeatherData(city = "Toronto")
//    val weatherData3 by viewModel.weatherData.observeAsState(initial = null)

    if (weatherData == null)
    {
        Text(text = "Loading...")
    }
    else
    {
        LazyVerticalGrid(
                modifier = Modifier.padding(innerPaddingValues),
                columns = GridCells.Fixed(count = 2)
        ) {
//                items(weatherDataList) { weatherData ->
//                    WeatherCard(weatherData)
//                }
            item {
                WeatherCard(weatherData = weatherData!!)
//                Text(text = weatherData.toString())
            }
            item {
                WeatherCard(weatherData = weatherData!!)
                //Text(text = weatherData.toString())
            }
            item {
                WeatherCard(weatherData = weatherData!!)
                //Text(text = weatherData.toString())
            }
        }
    }
}

private fun searchBarUI(navController: NavController)
{
    navController.navigate(NavDestination.SearchScreen.createRoute("Toronto"))
}
