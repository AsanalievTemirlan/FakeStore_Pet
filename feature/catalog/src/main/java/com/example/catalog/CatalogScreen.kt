package com.example.catalog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.core.LogUtil

@Composable
fun CatalogScreen(
    factory: ViewModelProvider.Factory
) {
    val owner = LocalContext.current as ViewModelStoreOwner
    val viewModel: CatalogViewModel = viewModel(factory = factory)
    val products by viewModel.products.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            LogUtil.d("Products: $products")
        }) {
            Text(text = "Show Products Log")
        }
    }
}
