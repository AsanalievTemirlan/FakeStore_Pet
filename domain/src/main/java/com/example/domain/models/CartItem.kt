package com.example.domain.models

import com.example.domain.models.product.ProductModelItem

data class CartItem(
    val id: Int,
    val title: String,
    val price: Double,
    val image: String,
    val quantity: Int
){
    val totalPrice: Double get() = price * quantity
}

fun ProductModelItem.toCartItem() = CartItem(
    id = id,
    title = title,
    price = price,
    image = image,
    quantity = 1
)