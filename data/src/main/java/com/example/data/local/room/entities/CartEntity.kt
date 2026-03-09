package com.example.data.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.models.CartItem

@Entity(tableName = "cart_table")
data class CartEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val price: Double,
    val image: String,
    val quantity: Int,
)

fun CartEntity.toDomain(): CartItem = CartItem(
    id = id,
    title = title,
    price = price,
    image = image,
    quantity = quantity
)

fun CartItem.toEntity(): CartEntity = CartEntity(
    id = id,
    title = title,
    price = price,
    image = image,
    quantity = quantity
)