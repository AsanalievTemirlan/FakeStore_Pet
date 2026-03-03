package com.example.data.dto.productDto

import com.example.domain.models.product.ProductModel

class ProductDto : ArrayList<ProductDtoItem>()

fun List<ProductDtoItem>.toDomain(): ProductModel =
    ProductModel().apply {
        addAll(this@toDomain.map { it.toDomain() }) }