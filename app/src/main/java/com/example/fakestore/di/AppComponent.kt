package com.example.fakestore.di

import androidx.lifecycle.ViewModelProvider
import com.example.catalog.di.CatalogModule
import com.example.core_network.di.NetworkModule
import com.example.data.di.ApiModule
import com.example.data.di.DataBaseModule
import com.example.data.di.RepositoryModule
import com.example.fakestore.app.App
import com.example.feature_cart.di.CartModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        NetworkModule::class,
        ApiModule::class,
        UseCaseModule::class,
        CatalogModule::class,
        ViewModelModule::class,
        DataBaseModule::class,
        CartModule::class
    ]
)
interface AppComponent {
    fun inject(app: App)
    fun viewModelFactory(): ViewModelProvider.Factory
}
