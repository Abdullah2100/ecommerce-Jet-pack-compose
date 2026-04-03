package com.example.core.domain.repository

import com.example.core.data.dto.CreateOrderDto
import com.example.core.network.NetworkCallHandler
import java.util.UUID

interface IOrderRepository {


    suspend fun submitOrder(cartData: CreateOrderDto): NetworkCallHandler
    suspend fun getMyOrders(pageNumber: Int): NetworkCallHandler
    suspend fun deleteOrder(orderId: UUID): NetworkCallHandler

}