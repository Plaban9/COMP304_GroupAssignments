package com.example.pb_jm_comp304sec003_lab03.views.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.pb_jm_comp304sec003_lab03.models.WeatherData

@Composable
fun WeatherCard(weatherData: WeatherData)
{
    ElevatedCard(
            modifier = Modifier.padding(10.dp),
            colors = CardDefaults.cardColors(
                    contentColor = MaterialTheme.colorScheme.secondary,
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            elevation = CardDefaults.elevatedCardElevation(
                    hoveredElevation = 10.dp,
                    defaultElevation = 2.dp,
                    pressedElevation = 5.dp,
            ),
            onClick = { /* TODO: Goto full details activity */ }
    ) {
        Box(
                modifier = Modifier
                    .padding(10.dp)
                    .size(200.dp),
                contentAlignment = Alignment.TopStart
        )
        {
            TemperatureEmoji(weatherData = weatherData)
            CityRegionCountry(weatherData = weatherData)
        }
    }
}

@Composable
fun TemperatureEmoji(weatherData: WeatherData)
{
    Row(
            modifier = Modifier
                .padding(1.dp)
//                .background(Red)
                .fillMaxWidth()
    ) {
        Column(
                modifier = Modifier
                    .padding(1.dp)
                    .wrapContentSize(align = Alignment.TopStart)
//                    .background(Blue)
                    .offset(y = -5.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                    modifier = Modifier
                        .padding(0.dp)
                        .align(Alignment.Start)
                        .wrapContentWidth(),
                    text = Math.round(weatherData.current.temp_c).toInt().toString(),
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left,
            )
        }
        Column(
                modifier = Modifier
                    .padding(1.dp)
                    .wrapContentSize(align = Alignment.Center)
//                    .background(Magenta)
                    .fillMaxWidth(0.5f),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                    modifier = Modifier
                        .padding(1.dp)
                        .align(Alignment.Start)
                        .wrapContentWidth(),
                    text = " °C",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left,
            )
        }
        Column(
                modifier = Modifier
                    .padding(1.dp)
                    .wrapContentWidth(align = Alignment.End)
//                    .background(Green)
                    .fillMaxWidth(1f),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.End
        ) {

            AsyncImage(
                model = "https://" + weatherData.current.condition.icon,
                contentDescription = "Weather Icon",
                modifier = Modifier.size(60.dp),
            )

        }
    }
}

@Composable
fun CityRegionCountry(weatherData: WeatherData)
{
    Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .wrapContentSize()
                .offset(y = 80.dp)
    )
    {
        Column(
                modifier = Modifier
                    .padding(1.dp)
                    .wrapContentSize(align = Alignment.Center),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {

            City(weatherData = weatherData)
            Region(weatherData = weatherData)
            Country(weatherData = weatherData)
        }
    }
}

@Composable
fun City(weatherData: WeatherData)
{
// City Name Text
    Text(
            modifier = Modifier
                .padding(1.dp),
            text = weatherData.location.name.toString(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
fun Region(weatherData: WeatherData)
{
    Text(
            modifier = Modifier
                .padding(1.dp),
            text = weatherData.location.region.toString(),
            textAlign = TextAlign.Center,
//                        fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.titleMedium,
    )
}

@Composable
fun Country(weatherData: WeatherData)
{
    Text(
            modifier = Modifier
                .padding(1.dp),
            text = weatherData.location.country.toString(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.titleSmall,
    )
}