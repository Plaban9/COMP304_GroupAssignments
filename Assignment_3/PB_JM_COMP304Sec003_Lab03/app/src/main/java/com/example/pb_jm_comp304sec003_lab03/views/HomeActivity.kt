package com.example.pb_jm_comp304sec003_lab03.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.pb_jm_comp304sec003_lab03.ui.theme.PB_JM_COMP304Sec003_Lab03Theme
import com.example.pb_jm_comp304sec003_lab03.viewmodels.WeatherDataViewModel

class HomeActivity : ComponentActivity() {

    private val viewModel: WeatherDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PB_JM_COMP304Sec003_Lab03Theme {
                MainUI()
            }
        }
    }

    @Preview
    @Composable
    private fun MainUI(){
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopAppBarUI() }
        ) { innerPadding ->
                ContentUI(innerPadding)
        }
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    private fun TopAppBarUI() {
        TopAppBar(
            title = { Text(text = "Weather App 🌦️") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            actions = {
                IconButton(
                    onClick = { searchBarUI(this@HomeActivity) }
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
    private fun ContentUI(innerPaddingValues: PaddingValues) {

        viewModel.fetchWeatherData(city = "Toronto")

        val weatherData by viewModel.weatherData.observeAsState(initial = null)

        if (weatherData == null) {
            Text(text = "Loading...")
        } else {
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

    private fun searchBarUI(context: Context) {
        val intent = Intent(context, SearchActivity::class.java)
        context.startActivity(intent)
    }
}
