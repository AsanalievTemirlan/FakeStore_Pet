package com.example.fakestore.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.catalog.catalogScreen.CatalogScreen
import com.example.catalog.singleProductScreen.SingleProductScreen

@Composable
fun AppNavHost(
    viewModelFactory: ViewModelProvider.Factory
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = CatalogRoute
    ) {
        composable<CatalogRoute> {
            CatalogScreen(factory = viewModelFactory){
                navController.navigate(SingleProductRoute(it))
            }
        }
        composable<SingleProductRoute> { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            if (productId != null) {
                SingleProductScreen(viewModelFactory, productId)
            }
        }
    }
}
