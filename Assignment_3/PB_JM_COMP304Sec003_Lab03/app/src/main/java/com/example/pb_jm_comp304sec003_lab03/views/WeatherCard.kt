package com.example.pb_jm_comp304sec003_lab03.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.pb_jm_comp304sec003_lab03.models.WeatherData

@Composable
fun WeatherCard(weatherData: WeatherData) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            // City Name Text
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                text = weatherData.location.name.toString(),
                textAlign = TextAlign.Center,
                fontSize = TextUnit(value = 25f, type = TextUnitType.Sp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Current Temp Text
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = weatherData.current.temp_c.toInt().toString() + "°"
                )

                // High/Low Temp Text
//                Text(
//                    modifier = Modifier.padding(5.dp),
//                    text = "${weatherData.highTemp}/${weatherData.lowTemp}"
//                )
            }
        }
    }
}