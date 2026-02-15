package com.example.fakestore.di

import com.example.domain.repositories.ProductsRepository
import com.example.domain.usecases.GetProductsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetProductsUseCase(
        repository: ProductsRepository
    ): GetProductsUseCase =
        GetProductsUseCase(repository)
}
