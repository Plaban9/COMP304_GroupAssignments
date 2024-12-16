package com.plaban.biswas.plaban_comp304_003_test_02.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plaban.biswas.plaban_comp304_003_test_02.RoomDB.StockInfo
import com.plaban.biswas.plaban_comp304_003_test_02.model.StockRepository
import kotlinx.coroutines.launch

class StockViewModel(private val repository: StockRepository) : ViewModel()
{
    var stocks = mutableStateOf<List<StockInfo>>(emptyList())
        private set
    var stocksByName = mutableStateOf<List<StockInfo>>(emptyList())
        private set


    init
    {
        viewModelScope.launch {
            val fetchStocks = repository.getStocksFromDB()
            stocks.value = fetchStocks
        }
    }

    fun getStocksFromDB(): List<StockInfo>
    {
        viewModelScope.launch {
            val fetchStocks = repository.getStocksFromDB()
            stocks.value = fetchStocks
        }

        return stocks.value
    }


    fun getStockWithName(stockTerm: String)
    {
        viewModelScope.launch {
            val fetchStockByName = repository.getStocksWithName(stockTerm)
            stocksByName.value = fetchStockByName
        }
    }

    fun insertToDB(companyStock: StockInfo)
    {
        viewModelScope.launch {
            repository.insertStock(companyStock)
            val dbfetchStocks = repository.getStocksFromDB()
            stocks.value = dbfetchStocks
        }
    }

    fun deleteFromDB(companyStock: StockInfo)
    {
        viewModelScope.launch {
            repository.deleteStock(companyStock)
            val dbfetchStocks = repository.getStocksFromDB()
            stocks.value = dbfetchStocks
        }
    }

    fun updateInDB(companyStock: StockInfo)
    {
        viewModelScope.launch {
            repository.updateStock(companyStock)
            val dbfetchStocks = repository.getStocksFromDB()
            stocks.value = dbfetchStocks
        }
    }
}