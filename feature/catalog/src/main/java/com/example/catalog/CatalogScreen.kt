package com.example.catalog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.core.LogUtil

@Composable
fun CatalogScreen(
    factory: ViewModelProvider.Factory
) {
    val viewModel: CatalogViewModel = viewModel(factory = factory)

    LaunchedEffect(Unit){
        LogUtil.d("${viewModel.products.value}")
    }

}