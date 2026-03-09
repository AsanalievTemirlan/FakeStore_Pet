package com.example.domain.usecases

import com.example.domain.repositories.CartRepository

class GetCartItemsUseCase(
    private val repository: CartRepository
) {
    suspend operator fun invoke() = repository.getCartItems()
}