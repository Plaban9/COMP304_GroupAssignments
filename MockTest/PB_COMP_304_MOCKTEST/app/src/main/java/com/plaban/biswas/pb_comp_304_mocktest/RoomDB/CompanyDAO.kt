package com.plaban.biswas.pb_comp_304_mocktest.RoomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CompanyDAO
{
    @Query("SELECT * FROM company_stock")
    suspend fun getAllCompanies(): List<CompanyStock>

    @Query("SELECT * FROM company_stock WHERE companyName LIKE :companyName")
    suspend fun getCompanyWithCompanyName(companyName: String): CompanyStock

    @Insert
    suspend fun insertCompanyToDB(company: CompanyStock)

    @Delete
    suspend fun deleteCompanyToDB(company: CompanyStock)

    @Update
    suspend fun updateCompanyToDB(company: CompanyStock)
}