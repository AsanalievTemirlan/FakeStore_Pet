package com.example.catalog.catalogScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.LogUtil
import com.example.domain.models.product.ProductModel
import com.example.domain.usecases.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class CatalogViewModel @Inject constructor(
    private val getProducts: GetProductsUseCase
) : ViewModel() {

    private val _products = MutableStateFlow(ProductModel())
    val products = _products.asStateFlow()

    init {
        viewModelScope.launch {
            loadProducts()
        }
    }

    suspend fun loadProducts() {
        getProducts().fold(
            onSuccess = { data ->
                _products.value = data
            },
            onFailure = { error ->
                LogUtil.d("Error loading products: ${error.message}")
            }
        )
    }

}