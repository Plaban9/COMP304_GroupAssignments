package com.plaban.biswas.plaban_comp304_003_test_02.model

import com.plaban.biswas.plaban_comp304_003_test_02.RoomDB.StockDao
import com.plaban.biswas.plaban_comp304_003_test_02.RoomDB.StockInfo

class StockRepository(private val stockDAO: StockDao)
{
    suspend fun getStocksFromDB(): List<StockInfo>
    {
        return stockDAO.getAllStocks()
    }

    suspend fun insertStock(stock: StockInfo)
    {
        stockDAO.insertStockToDB(stock)
    }

    suspend fun deleteStock(stock: StockInfo)
    {
        stockDAO.deleteStockFromDB(stock)
    }

    suspend fun updateStock(stock: StockInfo)
    {
        stockDAO.updateStockToDB(stock)
    }

    suspend fun getStocksWithName(stockName: String): List<StockInfo>
    {
        return stockDAO.getStockWithCompanyName(stockName)
    }
}