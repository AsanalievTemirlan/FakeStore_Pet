package com.example.catalog.singleProductScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.LogUtil
import com.example.core.UiState
import com.example.domain.models.CartItem
import com.example.domain.models.product.ProductModelItem
import com.example.domain.usecases.AddToCartUseCase
import com.example.domain.usecases.GetSingleProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SingleProductViewModel @Inject constructor(
    private val getSingleProductUseCase: GetSingleProductUseCase,
    private val addToCartUseCase: AddToCartUseCase
) : ViewModel() {

    private val _product =
        MutableStateFlow<UiState<ProductModelItem>>(UiState.Loading)

    val product = _product.asStateFlow()


    fun getProduct(id: Int) {
        viewModelScope.launch {
            _product.value = UiState.Loading
            LogUtil.d("id: $id")
            getSingleProductUseCase(id).fold(
                onSuccess = { data ->
                    LogUtil.d("data: $data")
                    _product.value = UiState.Success(data)
                },
                onFailure = { error ->
                    _product.value = UiState.Error(error.message ?: "Unknown error")
                }
            )
        }
    }

    fun add(cartItem: CartItem) {
        viewModelScope.launch {
            addToCartUseCase(cartItem)
        }
    }
}