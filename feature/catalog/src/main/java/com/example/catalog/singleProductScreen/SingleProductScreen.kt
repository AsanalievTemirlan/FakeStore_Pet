package com.example.catalog.singleProductScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.catalog.catalogScreen.CatalogViewModel
import com.example.core.LogUtil
import com.example.core.UiState

@Composable
fun SingleProductScreen(
    factory: ViewModelProvider.Factory,
    productId: Int
) {

    val viewModel: SingleProductViewModel = viewModel(factory = factory)
    val products by viewModel.product.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getProduct(productId)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            when (val state = products) {
                is UiState.Success -> LogUtil.d("Products: ${state.data}")
                is UiState.Error -> LogUtil.e("Error loading product: ${state.message}")
                is UiState.Loading -> LogUtil.d("Product is still loading")
            }
        }) {
            Text(text = "Show Detail Products Log")
        }
    }

}