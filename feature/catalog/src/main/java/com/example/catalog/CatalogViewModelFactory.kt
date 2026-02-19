package com.example.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecases.GetProductsUseCase
import javax.inject.Inject

class CatalogViewModelFactory @Inject constructor(
    private val getProducts: GetProductsUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CatalogViewModel::class.java)) {
            return CatalogViewModel(getProducts) as T
        }
        error("Unknown ViewModel $modelClass")
    }
}
