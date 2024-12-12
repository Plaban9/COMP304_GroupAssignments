package com.plaban.biswas.pb_comp_304_mocktest.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class DisplayActivity : ComponentActivity()
{
    var companyName = ""
    var opening = ""
    var closing = ""
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            val i = intent

            if (i.hasExtra("name"))
            {
                companyName = intent.getStringExtra("name").toString()
                opening = intent.getStringExtra("opening").toString()
                closing = intent.getStringExtra("closing").toString()
            }

            DisplayList()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DisplayList()
    {
        Column(Modifier.padding(10.dp)) {
            DisplayLabel()
            BackButton()
        }
    }

    @Composable
    fun DisplayLabel()
    {
        Column(Modifier.padding(10.dp)) {
            Text(text = "Company Name: " + companyName)
            Text(text = "Opening Price: " + opening)
            Text(text = "Closing Price: " + closing)
        }
    }

    @Composable
    fun BackButton()
    {
        Button(onClick = {
            val intent = Intent(this, PlabanActivity::class.java)
            startActivity(intent)
        })
        {
            Text(text = "Back")
        }
    }
}


