package com.example.core.domain.repository

import com.example.core.network.NetworkCallHandler

interface IPaymentRepository {


    suspend fun generatePaymentIntent(totalPrice: Long): NetworkCallHandler
}