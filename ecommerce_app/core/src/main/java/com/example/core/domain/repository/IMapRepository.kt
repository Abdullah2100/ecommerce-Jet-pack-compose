package com.example.core.domain.repository

import com.example.core.network.NetworkCallHandler

interface IMapRepository  {

    suspend fun getDistanceBetweenTwoPoint(
        origin: Pair<Double, Double>,
        destination: Pair<Double, Double>,
        key: String
    ): NetworkCallHandler
}