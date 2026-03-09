package com.example.data.repositories

import com.example.data.local.room.dao.CartDao
import com.example.data.local.room.entities.toDomain
import com.example.data.local.room.entities.toEntity
import com.example.domain.models.CartItem
import com.example.domain.repositories.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val cartDao: CartDao
) : CartRepository {

    override suspend fun getCartItems(): Result<Flow<List<CartItem>>> {
        return try {
            val flow = cartDao.getCartItems().map { entities ->
                entities.map { it.toDomain() }
            }
            Result.success(flow)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun addToCart(cartItem: CartItem) {
        cartDao.addToCart(cartItem.toEntity())
    }

    override suspend fun delete(id: Int) {
        cartDao.deleteCartItem(id)
    }

    override suspend fun clear() {
        cartDao.clearCart()
    }
}