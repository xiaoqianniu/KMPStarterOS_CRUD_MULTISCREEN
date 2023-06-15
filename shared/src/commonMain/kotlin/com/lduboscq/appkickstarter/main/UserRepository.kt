package com.lduboscq.appkickstarter.main

import com.lduboscq.appkickstarter.FrogData

interface UserRepository {
    suspend fun getUser(
        userName: String,
        email: String,
        password: String,
        confirmPassword: String
    ): UserData?

    suspend fun addUser(userData: UserData): UserData?
}