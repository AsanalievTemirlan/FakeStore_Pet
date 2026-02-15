package com.example.domain.repositories

import com.example.domain.models.ProductModel

interface ProductsRepository {
    suspend fun getProducts(): Result<ProductModel>
}