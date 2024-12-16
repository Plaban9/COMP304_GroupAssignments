package com.plaban.biswas.plaban_comp304_003_test_02.RoomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StockDao
{
    @Query("SELECT * FROM stock_info")
    suspend fun getAllStocks(): List<StockInfo>

    @Query("SELECT * FROM stock_info WHERE companyName LIKE :stockName")
    suspend fun getStockWithCompanyName(stockName: String): List<StockInfo>

    @Insert
    suspend fun insertStockToDB(stock: StockInfo)

    @Delete
    suspend fun deleteStockFromDB(stock: StockInfo)

    @Update
    suspend fun updateStockToDB(stock: StockInfo)
}