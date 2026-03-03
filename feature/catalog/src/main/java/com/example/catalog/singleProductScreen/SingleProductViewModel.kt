package com.example.catalog.singleProductScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.UiState
import com.example.domain.models.product.ProductModelItem
import com.example.domain.usecases.GetSingleProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SingleProductViewModel @Inject constructor(
    private val getSingleProductUseCase: GetSingleProductUseCase,
) : ViewModel() {

    private val _product =
        MutableStateFlow<UiState<ProductModelItem>>(UiState.Loading)

    val product = _product.asStateFlow()


    suspend fun getProduct(id: Int) {
        getSingleProductUseCase(id).fold(
            onSuccess = { data ->
                _product.value = UiState.Success(data)
            },
            onFailure = { error ->
                _product.value = UiState.Error(error.message ?: "Unknown error")
            }
        )
    }
}