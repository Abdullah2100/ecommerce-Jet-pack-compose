package com.example.core.domain.repository

import com.example.core.network.NetworkCallHandler
import java.io.File
import java.util.UUID

interface IBannerRepository {


    suspend fun getBannerByStoreId(storeId: UUID, pageNumber: Int): NetworkCallHandler
    suspend fun getRandomBanner(): NetworkCallHandler

    suspend fun createBanner(endDate: String, image: File): NetworkCallHandler

    suspend fun deleteBanner(bannerId: UUID): NetworkCallHandler
}