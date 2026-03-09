package com.example.data.network.dto.productDto


import com.example.domain.models.product.RatingModel
import com.google.gson.annotations.SerializedName

data class RatingDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("rate")
    val rate: Double
)

fun RatingDto.toDomain() =
    RatingModel(
        count = count,
        rate = rate
    )