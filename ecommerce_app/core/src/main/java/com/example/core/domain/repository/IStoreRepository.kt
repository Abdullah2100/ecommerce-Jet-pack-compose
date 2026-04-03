package com.example.core.domain.repository

import com.example.core.network.NetworkCallHandler
import java.io.File
import java.util.UUID

interface IStoreRepository {


    suspend fun createStore(
        name: String,
        wallpaperImage: File,
        smallImage: File,
        longitude: Double,
        latitude: Double
    ): NetworkCallHandler

    suspend fun updateStore(
        name: String? = null,
        wallpaperImage: File?,
        smallImage: File?,
        longitude: Double?,
        latitude: Double?
    ): NetworkCallHandler

    suspend fun getStoreById(id: UUID): NetworkCallHandler

}