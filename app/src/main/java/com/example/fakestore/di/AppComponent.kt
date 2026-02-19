package com.example.fakestore.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import com.example.catalog.CatalogPresentationModule
import com.example.catalog.CatalogViewModelFactory
import com.example.core_network.di.NetworkModule
import com.example.data.di.ApiModule
import com.example.data.di.RepositoryModule
import com.example.fakestore.app.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class, NetworkModule::class,
        ApiModule::class, UseCaseModule::class,
        CatalogPresentationModule::class]
)
interface AppComponent {
    fun inject(app: App)
    fun viewModelFactory(): ViewModelProvider.Factory
}
