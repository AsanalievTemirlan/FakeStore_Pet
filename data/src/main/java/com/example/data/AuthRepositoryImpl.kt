package com.example.data

import com.example.domain.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    override fun login() {
        println("login called")
    }
}
