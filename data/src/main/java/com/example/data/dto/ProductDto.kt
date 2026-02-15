package com.example.data.dto

import com.example.domain.models.ProductModel

class ProductDto : ArrayList<ProductDtoItem>()

fun List<ProductDtoItem>.toDomain(): ProductModel =
    ProductModel().apply {
        addAll(this@toDomain.map { it.toDomain() }) }