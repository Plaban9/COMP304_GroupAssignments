package com.plaban.biswas.pb_comp_304_mocktest.view

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
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.plaban.biswas.pb_comp_304_mocktest.RoomDB.CompanyDatabase
import com.plaban.biswas.pb_comp_304_mocktest.RoomDB.CompanyStock
import com.plaban.biswas.pb_comp_304_mocktest.data.CompanyRepository
import com.plaban.biswas.pb_comp_304_mocktest.ui.theme.PB_COMP_304_MOCKTESTTheme
import com.plaban.biswas.pb_comp_304_mocktest.viewmodel.CompaniesViewModel
import com.plaban.biswas.pb_comp_304_mocktest.viewmodel.ViewModelFactory

class PlabanActivity : ComponentActivity()
{
    //    companion object
//    {
    var companyList = mutableStateOf<List<CompanyStock>>(emptyList())
        private set

    //    }
    var globalSelected = -1

    var companyName = ""
    var openingPrice = -0.1
    var closingPrice = -0.1

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        val database = CompanyDatabase.getInstance(applicationContext)
        val repository = CompanyRepository(database.roomCityDao())
        val viewModelFactory = ViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory)[CompaniesViewModel::class.java]
        setContent {
            PB_COMP_304_MOCKTESTTheme {
                viewModel.getCompaniesFromDB()
                companyList = viewModel.companies
                MainView(viewModel)
            }
        }
    }

    @Composable
    fun MainView(viewModel: CompaniesViewModel)
    {
        Column {
            InsertCompanyDetails(viewModel = viewModel)
            DisplayList(viewModel = viewModel)
        }
    }

    //region Inputs
    @Composable
    fun InsertCompanyDetails(viewModel: CompaniesViewModel)
    {
        Column(Modifier.padding(10.dp)) {
            InsertCompanyDetailsText()
            InsertCompanyName()
            InsertOpeningPrice()
            InsertClosingPrice()
            InsertDetails(viewModel = viewModel)
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
                    companyName = newText
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
                    try
                    {
                        openingPrice = newText.toDouble()
                    }
                    catch (e: Exception)
                    {
                        openingPrice = -0.1
                    }
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
                    try
                    {
                        closingPrice = newText.toDouble()
                    }
                    catch (e: Exception)
                    {
                        closingPrice = -0.1
                    }
                },
                label = { Text(style = MaterialTheme.typography.titleLarge, text = "Closing Price") },
        )
    }

    @Composable
    fun InsertDetails(viewModel: CompaniesViewModel)
    {
        Button(onClick = {
            viewModel.insertToDB(CompanyStock(companyName, openingPrice, closingPrice))
            viewModel.getCompaniesFromDB()
            companyList = viewModel.companies
        })
        {
            Text(text = "Insert")
        }
    }

    //endregion

    //region Display
    @Composable
    fun DisplayList(viewModel: CompaniesViewModel)
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
        Text(text = "Display Company Information")
    }

    @Composable
    fun DisplayStockList(viewModel: CompaniesViewModel)
    {

//        companyList = viewModel.companies
//
//        LazyColumn {
//            companyList
//
//        }

        var selectedIndex by remember {
            mutableStateOf(-1)
        }

        val companyList = viewModel.getCompaniesFromDB()
        LazyColumn(
                Modifier.selectableGroup()
        ) {
            items(companyList.size) { id ->
                Text(companyList[id].companyName,
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
    fun DisplayStockButton(viewModel: CompaniesViewModel)
    {
        Button(onClick = {
            val companyList = viewModel.getCompaniesFromDB()
            val company = companyList[globalSelected]
            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("name", company.companyName)
            intent.putExtra("opening", company.openingPrice.toString())
            intent.putExtra("closing", company.closingPrice.toString())
            startActivity(intent)
        })
        {
            Text(text = "Display Stock")
        }
    }
    //endregion
}

