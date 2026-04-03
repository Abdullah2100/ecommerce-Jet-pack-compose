package com.example.core.domain.repository

import com.example.core.network.NetworkCallHandler
import java.util.UUID

interface IDeliveryRepository {


    suspend fun getDeliveriesBelongToStore(pageNumber: Int): NetworkCallHandler

    suspend fun createNewDelivery(userId: UUID): NetworkCallHandler


}