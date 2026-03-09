package com.example.data.network.dto.productDto


import com.example.domain.models.product.ProductModelItem
import com.google.gson.annotations.SerializedName

data class ProductDtoItem(
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("title")
    val title: String,
    @SerializedName("rating")
    val rating: RatingDto,
)

fun ProductDtoItem.toDomain() =
    ProductModelItem(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        title = title,
        rating = rating.toDomain()
    )