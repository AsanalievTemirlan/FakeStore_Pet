package com.example.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.domain.models.CartItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "cart_prefs")

class CartDataStore @Inject constructor(
    private val context: Context,
    private val gson: Gson
) {
    private val cartKey = stringPreferencesKey("cart_items")

    val cartFlow: Flow<List<CartItem>> = context.dataStore.data
        .map { preferences ->
            val json = preferences[cartKey] ?: ""
            if (json.isEmpty()) {
                emptyList()
            } else {
                val type = object : TypeToken<List<CartItem>>() {}.type
                gson.fromJson(json, type)
            }
        }

    suspend fun addToCart(item: CartItem) {
        context.dataStore.edit { preferences ->
            val currentList = getCartList(preferences[cartKey] ?: "")
            val existingItem = currentList.find { it.id == item.id }
            
            val newList = if (existingItem != null) {
                currentList.map { 
                    if (it.id == item.id) it.copy(quantity = it.quantity + item.quantity) else it 
                }
            } else {
                currentList + item
            }
            
            preferences[cartKey] = gson.toJson(newList)
        }
    }

    suspend fun removeFromCart(productId: Int) {
        context.dataStore.edit { preferences ->
            val currentList = getCartList(preferences[cartKey] ?: "")
            val newList = currentList.filter { it.id != productId }
            preferences[cartKey] = gson.toJson(newList)
        }
    }

    suspend fun clearCart() {
        context.dataStore.edit { preferences ->
            preferences.remove(cartKey)
        }
    }

    private fun getCartList(json: String): List<CartItem> {
        if (json.isEmpty()) return emptyList()
        val type = object : TypeToken<List<CartItem>>() {}.type
        return gson.fromJson(json, type)
    }
}