package com.example.pb_jm_comp304sec003_lab04.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pb_jm_comp304sec003_lab04.R
import com.example.pb_jm_comp304sec003_lab04.views.ui.theme.PB_JM_COMP304Sec003_Lab04Theme

class Jaydeep : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PB_JM_COMP304Sec003_Lab04Theme {
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
        LazyColumn (
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            contentPadding = PaddingValues(10.dp),
            userScrollEnabled = true,
        ) {
            item {
                CardUI()
            }
        }
    }

    @Composable
    private fun CardUI() {
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            onClick = { gotoMapActivity(this@Jaydeep) },
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
                    .height(150.dp),
                imageVector = Icons.Filled.Home,
                contentDescription = "Place X",
            )

            Row {
                // Title Text
                Text(
                    modifier = Modifier
                        .padding(5.dp)
                        .padding(start = 10.dp),
                    text = "The Toronto Art Gallery",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontWeight = FontWeight.Bold,
                )

                // Distance Text
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "(100 m)",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondary,
                )

                // Rating Text
                Text(
                    modifier = Modifier
                        .padding(5.dp)
                        .padding(end = 10.dp)
                        .fillMaxWidth(),
                    text = "⭐ 4.7",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondary,
                    textAlign = TextAlign.Right,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }

    private fun gotoMapActivity(context: Context) {
        val intent = Intent(context, Plaban::class.java)
        context.startActivity(intent)
    }
}
