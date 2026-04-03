package com.example.core.data.dto

import com.example.core.Utils.kSerializeChanger.UUIDSerialize
import com.example.core.network.kSerializeChanger.UUIDListSerialize
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class OrderDto(
    @Serializable(with = UUIDSerialize::class)
    val id: UUID,
    val longitude: Double,
    val latitude: Double,
    val userPhone: String,
    var name: String,
    var isAlreadyPayed: Boolean,
    val status:String,
    val symbol:String,
    val totalPrice: Long,
    val deliveryFee: Int,
    val orderItems:List<OrderItemDto>
)

@Serializable
data class OrderUpdateStatusDto(
    @Serializable(with = UUIDSerialize::class)
    val id: UUID,
    val status:String,
)
@Serializable
data class CreateOrderDto(
    val Longitude: Double,
    val Latitude: Double,
    val TotalPrice: Long,
    val Symbol: String,
    @Serializable(with = UUIDSerialize::class)
    val PaymentTypeId: UUID,
    val Items: List<CreateOrderItemDto>,
    val PaymentId: String?,
)

@Serializable
data class OrderRequestItemsDto(
    @Serializable(with = UUIDSerialize::class)
    val StoreId: UUID,
    val Price: Long,
    val Quantity: Int,
    @Serializable(with = UUIDSerialize::class)
    val ProductId: UUID,
    @Serializable(with = UUIDListSerialize::class)
    val ProductsVariantId: List<UUID>,
)
