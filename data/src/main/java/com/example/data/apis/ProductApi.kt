package com.example.data.apis

import com.example.data.Endpoints
import com.example.data.dto.productDto.ProductDto
import com.example.data.dto.productDto.ProductDtoItem
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {

    @GET(Endpoints.PRODUCTS)
    suspend fun getProducts(): ProductDto

    @GET(Endpoints.SINGLE_PRODUCT)
    suspend fun getSingleProduct(@Path("id") id: Int): ProductDtoItem
}