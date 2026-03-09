package com.example.domain.repositories

import com.example.domain.models.CartItem
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun getCartItems(): Result<Flow<List<CartItem>>>
    suspend fun addToCart(cartItem: CartItem)
    suspend fun delete(id: Int)
    suspend fun clear()
}