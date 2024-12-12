package com.plaban.biswas.pb_comp_304_mocktest.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plaban.biswas.pb_comp_304_mocktest.ui.theme.PB_COMP_304_MOCKTESTTheme

class PlabanActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            PB_COMP_304_MOCKTESTTheme {
                MainView()
            }
        }
    }

    @Composable
    fun MainView()
    {
        Column {
            InsertCompanyDetails()
            DisplayList()
        }
    }

    //region Inputs
    @Composable
    fun InsertCompanyDetails()
    {
        Column(Modifier.padding(10.dp)) {
            InsertCompanyDetailsText()
            InsertCompanyName()
            InsertOpeningPrice()
            InsertClosingPrice()
            InsertDetails()
        }

    }

    @Composable
    fun InsertCompanyDetailsText()
    {
        Text(text = "Company Details")
    }

    @Composable
    fun InsertCompanyName()
    {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
                placeholder = { Text("Enter Company Name...") },
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .fillMaxWidth(),
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                label = { Text(style = MaterialTheme.typography.titleLarge, text = "Company Name") },
        )
    }

    @Composable
    fun InsertOpeningPrice()
    {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
                placeholder = { Text("Enter Opening Price...") },
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .fillMaxWidth(),
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                label = { Text(style = MaterialTheme.typography.titleLarge, text = "Opening Price") },
        )
    }

    @Composable
    fun InsertClosingPrice()
    {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
                placeholder = { Text("Enter Closing Price...") },
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .fillMaxWidth(),
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                label = { Text(style = MaterialTheme.typography.titleLarge, text = "Closing Price") },
        )
    }

    @Composable
    fun InsertDetails()
    {
        Button(onClick = { /*TODO*/ })
        {
            Text(text = "Insert")
        }
    }

    //endregion

    //region Display
    @Composable
    fun DisplayList()
    {
        Column(Modifier.padding(10.dp)) {
            DisplayLabel()
            DisplayStockList()
            DisplayStockButton()
        }
    }

    @Composable
    fun DisplayLabel()
    {
        Text(text = "Display Company Information")
    }

    @Composable
    fun DisplayStockList()
    {
        LazyColumn {

        }
    }

    @Composable
    fun DisplayStockButton()
    {
        Button(onClick = {
            val intent = Intent(this, DisplayActivity::class.java)
            startActivity(intent)
        })
        {
            Text(text = "Display Stock")
        }
    }
    //endregion
}

