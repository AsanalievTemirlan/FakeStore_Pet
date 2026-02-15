package com.example.data.di

import com.example.data.repositories.AuthRepositoryImpl
import com.example.data.repositories.ProductsRepositoryImpl
import com.example.domain.repositories.AuthRepository
import com.example.domain.repositories.ProductsRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    fun bindProductRepository(
        productRepositoryImpl: ProductsRepositoryImpl
    ): ProductsRepository
}