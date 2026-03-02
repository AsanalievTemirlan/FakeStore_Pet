package com.example.fakestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.catalog.CatalogScreen
import com.example.fakestore.app.App
import com.example.fakestore.ui.theme.FakeStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        val appComponent = (application as App).appComponent
        
        setContent {
            FakeStoreTheme {
                CatalogScreen(factory = appComponent.viewModelFactory())
            }
        }
    }
}
