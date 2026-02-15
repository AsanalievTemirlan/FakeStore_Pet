package com.example.data.dto


import com.example.domain.models.ProductModelItem
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
    val title: String
)

fun ProductDtoItem.toDomain() =
    ProductModelItem(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        title = title
    )