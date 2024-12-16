//NAME: PLABAN BISWAS
//STUDENT ID: 301344949

package com.plaban.biswas.plaban_comp304_003_test_02.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.plaban.biswas.plaban_comp304_003_test_02.RoomDB.StockDatabase
import com.plaban.biswas.plaban_comp304_003_test_02.RoomDB.StockInfo
import com.plaban.biswas.plaban_comp304_003_test_02.model.StockRepository
import com.plaban.biswas.plaban_comp304_003_test_02.ui.theme.Plaban_COMP304_003_Test_02Theme
import com.plaban.biswas.plaban_comp304_003_test_02.viewmodel.StockViewModel
import com.plaban.biswas.plaban_comp304_003_test_02.viewmodel.ViewModelFactory

class PlabanActivity : ComponentActivity()
{
    var companyList = mutableStateOf<List<StockInfo>>(emptyList())
        private set

    var globalSelected = -1

    var stockSymbol = ""
    var companyName = ""
    var currentStockQuote = -0.1
    var yearlyAverageStockPrice = -0.1

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        val database = StockDatabase.getInstance(applicationContext)
        val repository = StockRepository(database.roomCityDao())
        val viewModelFactory = ViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory)[StockViewModel::class.java]

        setContent {
            Plaban_COMP304_003_Test_02Theme {
                viewModel.getStocksFromDB()
                companyList = viewModel.stocks
                MainView(viewModel)
            }
        }
    }

    @Composable
    fun MainView(viewModel: StockViewModel)
    {
        Column {
            InsertCompanyDetails(viewModel = viewModel)
            DisplayList(viewModel = viewModel)
        }
    }

    //region Inputs
    @Composable
    fun InsertCompanyDetails(viewModel: StockViewModel)
    {
        Column(Modifier.padding(10.dp)) {
            InsertStockDetailsText()
            InsertStockSymbol()
            InsertStockName()
            InsertStockQuote()
            InsertYearlyAverageStockPrice()
            InsertDetails(viewModel = viewModel)
        }

    }

    @Composable
    fun InsertStockDetailsText()
    {
        Text(text = "Stock Details")
    }

    @Composable
    fun InsertStockSymbol()
    {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
                placeholder = { Text("Enter Stock Symbol...") },
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .fillMaxWidth(),
                value = text,
                onValueChange = { newText ->
                    text = newText
                    stockSymbol = newText
                    globalSelected = -1
                },
                label = { Text(style = MaterialTheme.typography.titleLarge, text = "Stock Symbol") },
        )
    }

    @Composable
    fun InsertStockName()
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
                    companyName = newText
                },
                label = { Text(style = MaterialTheme.typography.titleLarge, text = "Company Name") },
        )
    }

    @Composable
    fun InsertStockQuote()
    {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
                placeholder = { Text("Enter Stock Quote...") },
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .fillMaxWidth(),
                value = text,
                onValueChange = { newText ->
                    text = newText
                    try
                    {
                        currentStockQuote = newText.toDouble()
                    }
                    catch (e: Exception)
                    {
                        currentStockQuote = -0.1
                    }
                },
                label = { Text(style = MaterialTheme.typography.titleLarge, text = "Stock Quote") },
        )
    }

    @Composable
    fun InsertYearlyAverageStockPrice()
    {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
                placeholder = { Text("Enter Yearly Average Stock Price...") },
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .fillMaxWidth(),
                value = text,
                onValueChange = { newText ->
                    text = newText
                    try
                    {
                        yearlyAverageStockPrice = newText.toDouble()
                    }
                    catch (e: Exception)
                    {
                        yearlyAverageStockPrice = -0.1
                    }
                },
                label = { Text(style = MaterialTheme.typography.titleLarge, text = "Yearly Average Stock Price") },
        )
    }

    @Composable
    fun InsertDetails(viewModel: StockViewModel)
    {
        val shouldShowDialog = remember { mutableStateOf(false) } // 1

        if (shouldShowDialog.value)
        {
            AlertDialog(shouldShowDialog = shouldShowDialog, title = "Invalid Input", message = "Please enter proper values.", buttonText = "OK")
        }

        Button(onClick = {

            if (currentStockQuote == -0.1 || yearlyAverageStockPrice == -0.1 || stockSymbol.isNullOrBlank() || stockSymbol.isNullOrEmpty() || companyName.isNullOrEmpty() || companyName.isNullOrBlank())
            {
                shouldShowDialog.value = true
            }
            else
            {
                viewModel.insertToDB(StockInfo(stockSymbol, companyName, currentStockQuote, yearlyAverageStockPrice))
                viewModel.getStocksFromDB()
                companyList = viewModel.stocks

                currentStockQuote = 0.1
                yearlyAverageStockPrice = 0.1
                stockSymbol = ""
                companyName = ""
            }
        })
        {
            Text(text = "INSERT")
        }
    }

    //endregion

    //region Display
    @Composable
    fun DisplayList(viewModel: StockViewModel)
    {
        Column(Modifier.padding(10.dp)) {
            DisplayLabel()
            DisplayStockList(viewModel = viewModel)
            DisplayStockButton(viewModel = viewModel)
        }
    }

    @Composable
    fun DisplayLabel()
    {
        Text(text = "Display Stocks Information")
    }

    @Composable
    fun DisplayStockList(viewModel: StockViewModel)
    {
        var selectedIndex by remember {
            mutableStateOf(-1)
        }

        val stocks = viewModel.getStocksFromDB()
        LazyColumn(
                Modifier.selectableGroup()
        ) {
            items(stocks.size) { id ->
                Text(stocks[id].stockSymbol,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                            .selectable(
                                    selected = id == selectedIndex,
                                    onClick = {
                                        if (selectedIndex != id)
                                        {
                                            selectedIndex = id
                                            globalSelected = selectedIndex
                                        }
                                        else
                                        {
                                            selectedIndex = -1
                                            globalSelected = selectedIndex
                                        }
                                    }
                            )
                )
            }
        }
    }

    @Composable
    fun DisplayStockButton(viewModel: StockViewModel)
    {
        val shouldShowDialog = remember { mutableStateOf(false) } // 1

        if (shouldShowDialog.value)
        {
            AlertDialog(shouldShowDialog = shouldShowDialog, title = "No Stock Selected", message = "Please select a Stock Symbol to Display Stock.", buttonText = "OK")
        }

        Button(onClick = {
            if (globalSelected != -1)
            {
                val stockList = viewModel.getStocksFromDB()
                val stock = stockList[globalSelected]
                val intent = Intent(this, BiswasActivity::class.java)
                intent.putExtra("symbol", stock.stockSymbol)
                intent.putExtra("name", stock.companyName)
                intent.putExtra("current", stock.currentStockQuote.toString())
                intent.putExtra("yearly", stock.yearlyAverageStockPrice.toString())
                startActivity(intent)
            }
            else
            {
                shouldShowDialog.value = true
            }
        })
        {
            Text(text = "DISPLAY STOCKS")
        }
    }

    @Composable
    fun AlertDialog(shouldShowDialog: MutableState<Boolean>, title: String, message: String, buttonText: String)
    {
        if (shouldShowDialog.value)
        {
            AlertDialog(
                    onDismissRequest = {
                        shouldShowDialog.value = false
                    },
                    title = { Text(text = title) },
                    text = { Text(text = message) },
                    confirmButton = {
                        Button(
                                onClick = {
                                    shouldShowDialog.value = false
                                }
                        ) {
                            Text(
                                    text = buttonText,
                                    color = Color.White
                            )
                        }
                    }
            )
        }
    }
    //endregion
}