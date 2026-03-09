package com.example.domain.usecases

import com.example.domain.models.CartItem
import com.example.domain.repositories.CartRepository

class AddToCartUseCase(
    private val repository: CartRepository
) {
    suspend operator fun invoke(cartItem: CartItem) = repository.addToCart(cartItem)
}