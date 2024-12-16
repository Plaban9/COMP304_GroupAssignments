package com.plaban.biswas.plaban_comp304_003_test_02.RoomDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stock_info")
data class StockInfo(
        @PrimaryKey val stockSymbol: String,
        val companyName: String,
        val currentStockQuote: Double,
        val yearlyAverageStockPrice: Double
)