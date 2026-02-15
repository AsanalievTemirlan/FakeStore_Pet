package com.example.fakestore.app

import android.app.Application
import com.example.domain.AuthRepository
import com.example.fakestore.DaggerAppComponent
import javax.inject.Inject

class App: Application() {

    @Inject
    lateinit var authRepository: AuthRepository

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.create().inject(this)
        authRepository.login()
    }
}