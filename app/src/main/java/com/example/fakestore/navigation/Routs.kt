package com.example.fakestore.navigation

import kotlinx.serialization.Serializable


@Serializable
object CatalogRoute

@Serializable
object CartRoute{
}

@Serializable
data class SingleProductRoute(val productId: Int)