package com.example.catalog.catalogScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.UiState
import com.example.domain.models.product.ProductModel
import com.example.domain.usecases.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class CatalogViewModel @Inject constructor(
    private val getProducts: GetProductsUseCase
) : ViewModel() {

    private val _products = MutableStateFlow<UiState<ProductModel>>(UiState.Loading)
    val products = _products.asStateFlow()

    init {
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            _products.value = UiState.Loading
            getProducts().fold(
                onSuccess = { data ->
                    _products.value = UiState.Success(data)
                },
                onFailure = { error ->
                    _products.value = UiState.Error(error.message ?: "Unknown error")
                }
            )
        }
    }

}