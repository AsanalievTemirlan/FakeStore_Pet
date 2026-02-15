package com.example.domain.usecases

import com.example.domain.repositories.ProductsRepository

class GetProductsUseCase(
    private val repository: ProductsRepository
) {
    suspend operator fun invoke() = repository.getProducts()
}