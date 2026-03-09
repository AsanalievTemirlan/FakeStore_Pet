package com.example.domain.usecases

import com.example.domain.repositories.CartRepository

class ClearCartUseCase(
    private val repository: CartRepository
) {
    suspend operator fun invoke() = repository.clear()
}