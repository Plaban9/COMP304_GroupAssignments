package com.example.pb_jm_comp304sec003_lab04.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pb_jm_comp304sec003_lab04.views.ui.theme.PB_JM_COMP304Sec003_Lab04Theme

class Plaban : ComponentActivity() {
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
        ) { innerPadding ->
            ContentUI(innerPadding = innerPadding)
        }
    }

    @Composable
    private fun ContentUI(innerPadding: PaddingValues) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Icon(
                modifier = Modifier.size(50.dp),
                imageVector = Icons.Outlined.Settings,
                contentDescription = "Work in Progress",
                )

            Text(
                modifier = Modifier.padding(innerPadding),
                text = "Work in progress",
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}