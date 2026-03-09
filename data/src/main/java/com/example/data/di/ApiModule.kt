package com.example.data.di

import com.example.data.network.apis.ProductApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    fun provideProductApi(
        retrofit: Retrofit
    ): ProductApi =
        retrofit.create(ProductApi::class.java)
}