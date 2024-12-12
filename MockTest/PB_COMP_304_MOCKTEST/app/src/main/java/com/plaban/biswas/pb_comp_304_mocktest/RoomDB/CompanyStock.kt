package com.plaban.biswas.pb_comp_304_mocktest.RoomDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company_stock")
data class CompanyStock(
        @PrimaryKey val companyName: String,
        val openingPrice: Double,
        val closingPrice: Double
)
