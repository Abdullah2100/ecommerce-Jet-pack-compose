package com.example.core.domain.repository

import com.example.core.network.NetworkCallHandler
import java.util.UUID

interface IOrderItemRepository {


    suspend fun getMyOrderItemForStoreId(pageNumber: Int): NetworkCallHandler


    suspend fun updateOrderItemStatus(id: UUID, status: Int): NetworkCallHandler
}