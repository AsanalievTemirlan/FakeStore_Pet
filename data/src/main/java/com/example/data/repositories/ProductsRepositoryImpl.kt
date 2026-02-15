package com.example.data.repositories

import com.example.data.apis.ProductApi
import com.example.data.dto.toDomain
import com.example.domain.models.ProductModel
import com.example.domain.repositories.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productsApi: ProductApi
) : ProductsRepository {
    override suspend fun getProducts(): Result<ProductModel> {
        return try {
            return Result.success(productsApi.getProducts().toDomain())
        } catch (
            e: Exception
        ) {
            Result.failure(e)
        }
    }

}