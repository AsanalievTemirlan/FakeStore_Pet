package com.example.data.apis

import com.example.data.Endpoints
import com.example.data.dto.ProductDto
import com.example.data.dto.ProductDtoItem
import retrofit2.http.GET

interface ProductApi {

    @GET(Endpoints.PRODUCTS)
    suspend fun getProducts(): ProductDto

}