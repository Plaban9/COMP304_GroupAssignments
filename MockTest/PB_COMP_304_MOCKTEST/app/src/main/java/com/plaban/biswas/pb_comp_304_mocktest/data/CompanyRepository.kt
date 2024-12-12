package com.plaban.biswas.pb_comp_304_mocktest.data

import com.plaban.biswas.pb_comp_304_mocktest.RoomDB.CompanyDAO
import com.plaban.biswas.pb_comp_304_mocktest.RoomDB.CompanyStock

class CompanyRepository(private val companyDAO: CompanyDAO)
{
    suspend fun getCompaniesFromDB(): List<CompanyStock>
    {
        return companyDAO.getAllCompanies()
    }

    suspend fun insertCompany(company: CompanyStock)
    {
        companyDAO.insertCompanyToDB(company)
    }

    suspend fun deleteCompany(company: CompanyStock)
    {
        companyDAO.deleteCompanyToDB(company)
    }

    suspend fun updateCompany(company: CompanyStock)
    {
        companyDAO.updateCompanyToDB(company)
    }

    suspend fun getCompaniesWithName(companyName: String): CompanyStock
    {
        return companyDAO.getCompanyWithCompanyName(companyName)
    }
}