package com.example.core.domain.repository

import com.example.core.network.NetworkCallHandler

interface IVariantRepository {

    suspend fun getVariant(pageNumber: Int): NetworkCallHandler

}