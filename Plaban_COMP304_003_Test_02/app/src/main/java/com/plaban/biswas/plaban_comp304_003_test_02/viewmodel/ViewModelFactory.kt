package com.plaban.biswas.plaban_comp304_003_test_02.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.plaban.biswas.plaban_comp304_003_test_02.model.StockRepository

class ViewModelFactory(private val repository: StockRepository) :
        ViewModelProvider.Factory
{

    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(StockViewModel::class.java))
        {
            return StockViewModel(repository) as T
        }
        else
        {
            throw IllegalArgumentException("Error")
        }
    }
}