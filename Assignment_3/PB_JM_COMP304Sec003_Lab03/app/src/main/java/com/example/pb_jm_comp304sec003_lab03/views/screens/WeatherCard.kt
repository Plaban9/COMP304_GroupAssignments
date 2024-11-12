package com.example.pb_jm_comp304sec003_lab03.views.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
                    defaultElevation = 0.dp,
                    pressedElevation = 5.dp,
            ),
            onClick = { /* TODO: Goto full details activity */ }
    ) {
        Box(
                modifier = Modifier
                    .padding(10.dp)
                    .size(200.dp),
                contentAlignment = Alignment.TopStart
        ) {
            Column(
                    modifier = Modifier
                        .padding(1.dp)
                        .wrapContentSize(align = Alignment.Center),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Current Temp Text
                Text(
                        modifier = Modifier
                            .padding(1.dp)
                            .align(Alignment.Start)
                            .wrapContentWidth(),
                        text = Math.round(weatherData.current.temp_c).toInt().toString() + "° C",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Left,
                )

                // City Name Text
                Text(
                        modifier = Modifier
                            .padding(1.dp)
                            .align(Alignment.CenterHorizontally),
                        text = weatherData.location.name.toString(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.ExtraBold,
                        style = MaterialTheme.typography.headlineLarge,
                )

                Text(
                        modifier = Modifier
                            .padding(1.dp),
                        text = weatherData.location.region.toString(),
                        textAlign = TextAlign.Center,
//                        fontWeight = FontWeight.Medium,
                        style = MaterialTheme.typography.titleMedium,
                )

                Text(
                        modifier = Modifier
                            .padding(1.dp),
                        text = weatherData.location.country.toString(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light,
                        style = MaterialTheme.typography.titleSmall,
                )
            }
        }
    }
}