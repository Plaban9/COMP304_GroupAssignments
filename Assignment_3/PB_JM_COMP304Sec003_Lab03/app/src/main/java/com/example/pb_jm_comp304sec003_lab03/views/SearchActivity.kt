package com.example.pb_jm_comp304sec003_lab03.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pb_jm_comp304sec003_lab03.views.ui.theme.PB_JM_COMP304Sec003_Lab03Theme

class SearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PB_JM_COMP304Sec003_Lab03Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopAppBarUI() },
                ) { innerPadding ->
                    ContentUI(innerPaddingValues = innerPadding)
                }
            }
        }
    }

    @Preview
    @Composable
    private fun TopAppBarUI() {
        var searchText by rememberSaveable { mutableStateOf("") }

        OutlinedTextField (
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search Icon",
                    modifier = Modifier.size(24.dp)
                )
            },
            placeholder = { Text(text = "Enter city name") },
            singleLine = true,
            label = { Text(text = "Search") },
        )
    }

    @Composable
    private fun ContentUI(innerPaddingValues: PaddingValues) {

    }
}

