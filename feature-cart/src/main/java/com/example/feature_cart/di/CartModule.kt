package com.example.feature_cart.di

import androidx.lifecycle.ViewModel
import com.example.core.ViewModelKey
import com.example.feature_cart.CartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CartModule {

    @Binds
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    fun bindCartViewModel(viewModel: CartViewModel): ViewModel

}