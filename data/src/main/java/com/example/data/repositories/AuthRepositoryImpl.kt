package com.example.data.repositories

import com.example.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    override fun login() {
        println("login called")
    }
}
