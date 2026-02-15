package com.example.fakestore.di

import com.example.data.RepositoryModule
import com.example.fakestore.app.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface AppComponent {
    fun inject(app: App)
}
