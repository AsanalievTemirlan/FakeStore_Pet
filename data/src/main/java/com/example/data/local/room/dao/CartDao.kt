package com.example.data.local.room.dao

import androidx.room.*
import com.example.data.local.room.entities.CartEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Query("SELECT * FROM cart_table")
    fun getCartItems(): Flow<List<CartEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCartItem(cartEntity: CartEntity): Long

    @Query("UPDATE cart_table SET quantity = quantity + :addQuantity WHERE id = :productId")
    suspend fun incrementQuantity(productId: Int, addQuantity: Int)

    @Transaction
    suspend fun addToCart(cartEntity: CartEntity) {
        val id = insertCartItem(cartEntity)
        if (id == -1L) {
            incrementQuantity(cartEntity.id, cartEntity.quantity)
        }
    }

    @Query("DELETE FROM cart_table WHERE id = :productId")
    suspend fun deleteCartItem(productId: Int)

    @Query("DELETE FROM cart_table")
    suspend fun clearCart()
}