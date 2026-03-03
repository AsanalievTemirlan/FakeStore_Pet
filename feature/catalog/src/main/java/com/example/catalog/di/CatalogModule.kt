package com.example.catalog.di

import androidx.lifecycle.ViewModel
import com.example.catalog.catalogScreen.CatalogViewModel
import com.example.catalog.singleProductScreen.SingleProductViewModel
import com.example.core.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CatalogModule {
    @Binds
    @IntoMap
    @ViewModelKey(CatalogViewModel::class)
    fun bindCatalogViewModel(viewModel: CatalogViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SingleProductViewModel::class)
    fun bindSingleProductViewModel(viewModel: SingleProductViewModel): ViewModel
}