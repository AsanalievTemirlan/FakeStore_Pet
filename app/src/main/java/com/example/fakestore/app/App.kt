package com.example.fakestore.app

import android.app.Application
import com.example.domain.repositories.ProductsRepository
import com.example.fakestore.di.AppComponent
import com.example.fakestore.di.DaggerAppComponent
import javax.inject.Inject

class App : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
        appComponent.inject(this)
    }
}
