package com.plaban.biswas.pb_comp_304_mocktest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.plaban.biswas.pb_comp_304_mocktest.data.CompanyRepository

class ViewModelFactory(private val repository: CompanyRepository) :
        ViewModelProvider.Factory
{

    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(CompaniesViewModel::class.java))
        {
            return CompaniesViewModel(repository) as T
        }
        else
        {
            throw IllegalArgumentException("Error")
        }
    }
}