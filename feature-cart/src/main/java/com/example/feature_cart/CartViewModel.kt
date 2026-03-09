package com.example.feature_cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.UiState
import com.example.domain.models.CartItem
import com.example.domain.usecases.AddToCartUseCase
import com.example.domain.usecases.ClearCartUseCase
import com.example.domain.usecases.DeleteCartItemUseCase
import com.example.domain.usecases.GetCartItemsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CartViewModel @Inject constructor(
    private val getCartItems: GetCartItemsUseCase,
    private val clearCartUseCase: ClearCartUseCase,
    private val deleteCartItemUseCase: DeleteCartItemUseCase,
    private val addToCartUseCase: AddToCartUseCase
) : ViewModel() {

    private val _cartItems = MutableStateFlow<UiState<List<CartItem>>>(UiState.Loading)
    val cartItems = _cartItems.asStateFlow()

    init {
        viewModelScope.launch {
            getCart()
        }
    }

    private suspend fun getCart() {
        getCartItems().fold(
            onSuccess = { data ->
                data.collect {
                    _cartItems.value = UiState.Success(it)
                }
            },
            onFailure = { error ->
                _cartItems.value = UiState.Error(error.message ?: "Unknown error")
            }
        )
    }

    fun clear(){
        viewModelScope.launch {
            clearCartUseCase()
        }
    }
    fun delete(id: Int){
        viewModelScope.launch {
            deleteCartItemUseCase(id)
        }
    }
    fun add(item: CartItem){
        viewModelScope.launch {
            addToCartUseCase(item)
        }
    }
}