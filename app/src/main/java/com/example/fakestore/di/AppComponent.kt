package com.example.fakestore.di

import com.example.core_network.di.NetworkModule
import com.example.data.di.ApiModule
import com.example.data.di.RepositoryModule
import com.example.domain.repositories.ProductsRepository
import com.example.fakestore.app.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class, NetworkModule::class, ApiModule::class, UseCaseModule::class]
)
interface AppComponent {
    fun inject(app: App)
    fun productsRepository(): ProductsRepository

}
