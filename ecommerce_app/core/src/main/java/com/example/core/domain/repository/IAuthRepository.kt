package com.example.core.domain.repository

import com.example.core.network.NetworkCallHandler
import com.example.core.data.dto.LoginDto
import com.example.core.data.dto.SignupDto

interface IAuthRepository {

    suspend fun login(loginData: LoginDto): NetworkCallHandler

    suspend fun signup(data: SignupDto): NetworkCallHandler

    suspend fun getOtp(email: String): NetworkCallHandler

    suspend fun verifyingOtp(email: String, otp: String): NetworkCallHandler

    suspend fun resetPassword(
        email: String,
        otp: String,
        newPassword: String
    ): NetworkCallHandler

}