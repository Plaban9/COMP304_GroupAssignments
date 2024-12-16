//NAME: PLABAN BISWAS
//STUDENT ID: 301344949

package com.plaban.biswas.plaban_comp304_003_test_02.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plaban.biswas.plaban_comp304_003_test_02.view.ui.theme.Plaban_COMP304_003_Test_02Theme

class BiswasActivity : ComponentActivity()
{
    var stockSymbol = ""
    var companyName = ""
    var current = ""
    var yearly = ""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            Plaban_COMP304_003_Test_02Theme {
                val i = intent

                if (i.hasExtra("name"))
                {
                    stockSymbol = intent.getStringExtra("symbol").toString()
                    companyName = intent.getStringExtra("name").toString()
                    current = intent.getStringExtra("current").toString()
                    yearly = intent.getStringExtra("yearly").toString()
                }

                DisplayList()
            }
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
            Text(text = "Stock Symbol: " + stockSymbol)
            Text(text = "Company Name: " + companyName)
            Text(text = "Current Stock Quote: " + current)
            Text(text = "Yearly Average Closing Price: " + yearly)
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