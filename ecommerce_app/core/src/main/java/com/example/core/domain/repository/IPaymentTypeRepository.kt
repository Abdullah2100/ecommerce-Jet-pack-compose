package com.example.core.domain.repository

import com.example.core.network.NetworkCallHandler

interface IPaymentTypeRepository {
    suspend fun getPaymentTypes(pageNumber: Int): NetworkCallHandler

}