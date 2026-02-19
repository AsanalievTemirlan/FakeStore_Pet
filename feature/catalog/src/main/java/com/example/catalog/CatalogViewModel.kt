package com.example.catalog

import androidx.lifecycle.ViewModel
import com.example.core.LogUtil
import com.example.domain.models.ProductModel
import com.example.domain.usecases.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


class CatalogViewModel @Inject constructor(
    private val getProducts: GetProductsUseCase
) : ViewModel() {

    val products = MutableStateFlow(ProductModel())
    private val _products = products.asStateFlow()

    suspend fun loadProducts() {
        getProducts().fold(
            onSuccess = { data ->
                products.value = data
            },
            onFailure = { error ->
                LogUtil.d("Error loading products: ${error.message}")
            }
        )
    }

}