package com.example.domain.repositories

import com.example.domain.models.product.ProductModel
import com.example.domain.models.product.ProductModelItem

interface ProductsRepository {
    suspend fun getProducts(): Result<ProductModel>
    suspend fun getSingleProduct(id: Int): Result<ProductModelItem>
}