package com.example.data.repositories

import com.example.data.network.apis.ProductApi
import com.example.data.network.dto.productDto.toDomain
import com.example.domain.models.product.ProductModel
import com.example.domain.models.product.ProductModelItem
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

    override suspend fun getSingleProduct(id: Int): Result<ProductModelItem> {
        return try {
            return Result.success(productsApi.getSingleProduct(id).toDomain())
        } catch (
            e: Exception
        ) {
            Result.failure(e)
        }

    }

}