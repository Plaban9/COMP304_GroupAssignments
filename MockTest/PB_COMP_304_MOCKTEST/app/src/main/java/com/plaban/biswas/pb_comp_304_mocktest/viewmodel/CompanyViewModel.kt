package com.plaban.biswas.pb_comp_304_mocktest.viewmodel


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plaban.biswas.pb_comp_304_mocktest.RoomDB.CompanyStock
import com.plaban.biswas.pb_comp_304_mocktest.data.CompanyRepository
import kotlinx.coroutines.launch

class CompaniesViewModel(private val repository: CompanyRepository) : ViewModel()
{
    var companies = mutableStateOf<List<CompanyStock>>(emptyList())
        private set
    private val company = mutableStateOf<CompanyStock?>(null)


    init
    {
        viewModelScope.launch {
            val fetchCompanies = repository.getCompaniesFromDB()
            companies.value = fetchCompanies
        }
    }

    fun getCompaniesFromDB(): List<CompanyStock>
    {
        viewModelScope.launch {
            val fetchCompanies = repository.getCompaniesFromDB()
            companies.value = fetchCompanies
        }

        return companies.value
    }


    fun getCompanyWithName(cityTerm: String)
    {
        viewModelScope.launch {
            val fetchCompanyByName = repository.getCompaniesWithName(cityTerm)
            company.value = fetchCompanyByName
        }
    }

    fun insertToDB(companyStock: CompanyStock)
    {
        viewModelScope.launch {
            repository.insertCompany(companyStock)
            val dbfetchCompanies = repository.getCompaniesFromDB()
            companies.value = dbfetchCompanies
        }
    }

    fun deleteFromDB(companyStock: CompanyStock)
    {
        viewModelScope.launch {
            repository.deleteCompany(companyStock)
            val dbfetchCities = repository.getCompaniesFromDB()
            companies.value = dbfetchCities
        }
    }

    fun updateInDB(companyStock: CompanyStock)
    {
        viewModelScope.launch {
            repository.updateCompany(companyStock)
            val dbfetchCities = repository.getCompaniesFromDB()
            companies.value = dbfetchCities
        }
    }
}