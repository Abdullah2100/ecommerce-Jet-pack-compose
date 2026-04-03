package com.example.core.data.repository

import com.example.core.network.NetworkCallHandler
import com.example.core.data.dto.AuthDto
import com.example.core.data.dto.CreateReseatPasswordDto
import com.example.core.data.dto.CreateVerificationDto
import com.example.core.data.dto.ForgetPasswordDto
import com.example.core.data.dto.LoginDto
import com.example.core.data.dto.SignupDto
import com.example.core.domain.Secrets
import com.example.core.domain.repository.IAuthRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import java.io.IOException
import java.net.UnknownHostException

class AuthRepository(val client: HttpClient) : IAuthRepository {

    override suspend fun login(loginData: LoginDto): NetworkCallHandler {
        return try {
            val fullUrl = Secrets.getUrl() + "/User/login"
            val result = client.post(fullUrl) {
                setBody(loginData)
                contentType(ContentType.Application.Json)
            }

            if (result.status == HttpStatusCode.Companion.OK) {
                NetworkCallHandler.Successful(result.body<AuthDto>())
            } else {
                NetworkCallHandler.Error(result.body<String>())
            }

        } catch (e: UnknownHostException) {

            return NetworkCallHandler.Error(e.message)

        } catch (e: IOException) {

            return NetworkCallHandler.Error(e.message)

        } catch (e: Exception) {

            return NetworkCallHandler.Error(e.message)
        }
    }

    override suspend fun signup(data: SignupDto): NetworkCallHandler {
        try {
            val fullUrl = Secrets.getUrl() + "/User/signup"
            val result = client.post(fullUrl) {
                setBody(data)
                contentType(ContentType.Application.Json)
            }

            return if (result.status == HttpStatusCode.Companion.Created) {
                NetworkCallHandler.Successful(result.body<AuthDto>())
            } else {
                NetworkCallHandler.Error(result.body())
            }

        } catch (e: UnknownHostException) {

            return NetworkCallHandler.Error(e.message)

        } catch (e: IOException) {

            return NetworkCallHandler.Error(e.message)

        } catch (e: Exception) {

            return NetworkCallHandler.Error(e.message)
        }
    }

    override suspend fun getOtp(email: String): NetworkCallHandler {
        return try {
            val fullUrl = Secrets.getUrl() + "/User/generateOtp"
            val result = client.post(fullUrl) {
                setBody(ForgetPasswordDto(email))
                contentType(ContentType.Application.Json)
            }

            if (result.status == HttpStatusCode.Companion.NoContent) {
                NetworkCallHandler.Successful(true)
            } else {
                NetworkCallHandler.Error(result.body())
            }

        } catch (e: UnknownHostException) {

            return NetworkCallHandler.Error(e.message)

        } catch (e: IOException) {

            return NetworkCallHandler.Error(e.message)

        } catch (e: Exception) {

            return NetworkCallHandler.Error(e.message)
        }
    }

    override suspend fun verifyingOtp(email: String, otp: String): NetworkCallHandler {
        return try {
            val fullUrl = Secrets.getUrl() + "/User/otpVerification"
            val result = client.post(fullUrl) {
                setBody(CreateVerificationDto(email, otp))
                contentType(ContentType.Application.Json)
            }

            if (result.status == HttpStatusCode.Companion.NoContent) {
                NetworkCallHandler.Successful(true)
            } else {
                NetworkCallHandler.Error(result.body())
            }

        } catch (e: UnknownHostException) {

            return NetworkCallHandler.Error(e.message)

        } catch (e: IOException) {

            return NetworkCallHandler.Error(e.message)

        } catch (e: Exception) {

            return NetworkCallHandler.Error(e.message)
        }
    }

    override suspend fun resetPassword(
        email: String,
        otp: String,
        newPassword: String
    ): NetworkCallHandler {
        return try {
            val fullUrl = Secrets.getUrl() + "/User/reseatPassword"
            val result = client.post(fullUrl) {
                setBody(
                    CreateReseatPasswordDto(
                        Email = email,
                        Otp = otp,
                        Password = newPassword
                    )
                )
                contentType(ContentType.Application.Json)
            }

            if (result.status == HttpStatusCode.Companion.OK) {
                NetworkCallHandler.Successful(result.body<AuthDto>())
            } else {
                NetworkCallHandler.Error(result.body<String>())
            }

        } catch (e: UnknownHostException) {

            return NetworkCallHandler.Error(e.message)

        } catch (e: IOException) {

            return NetworkCallHandler.Error(e.message)

        } catch (e: Exception) {

            return NetworkCallHandler.Error(e.message)
        }
    }


}