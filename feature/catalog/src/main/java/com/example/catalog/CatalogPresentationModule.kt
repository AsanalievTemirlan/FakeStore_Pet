package com.example.catalog

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
interface CatalogPresentationModule {

    @Binds
    fun bindFactory(
        impl: CatalogViewModelFactory
    ): ViewModelProvider.Factory
}