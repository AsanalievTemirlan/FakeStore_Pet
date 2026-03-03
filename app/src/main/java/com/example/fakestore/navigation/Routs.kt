package com.example.fakestore.navigation

import kotlinx.serialization.Serializable


@Serializable
object CatalogRoute

@Serializable
data class SingleProductRoute(val productId: Int)