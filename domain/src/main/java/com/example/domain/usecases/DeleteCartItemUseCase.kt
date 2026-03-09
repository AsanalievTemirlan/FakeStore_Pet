package com.example.domain.usecases

import com.example.domain.repositories.CartRepository

class DeleteCartItemUseCase(
    private val repository: CartRepository
) {
    suspend operator fun invoke(id: Int) = repository.delete(id)
}