package com.example.core.domain.repository

import com.example.core.network.NetworkCallHandler


interface ICurrencyRepository {


    suspend fun getStoreCurrencies(pageNumber: Int): NetworkCallHandler
}