package com.example.core.data.dto


import com.example.core.Utils.kSerializeChanger.UUIDSerialize
import com.example.core.network.kSerializeChanger.UUIDListSerialize
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class OrderItemDto(
    @Serializable(with = UUIDSerialize::class)
    val id: UUID,
    @Serializable(with = UUIDSerialize::class)
    val orderId: UUID,
    val price: Long,
    val quantity: Int,
    val address: List<AddressWithTitleDto>? = null,
    val product: OrderProductDto? = null,
    val productVariant: List<OrderVariantDto>? = null,
    val orderItemStatus: String,
    val orderStatusName: String
)


@Serializable
data class CreateOrderItemDto(
    @Serializable(with = UUIDSerialize::class)
    val StoreId: UUID,
    val Price: Int,
    val Quantity: Int,
    @Serializable(with = UUIDSerialize::class)
    val ProductId: UUID,
    @Serializable(with = UUIDListSerialize::class)
    val ProductsVariantId: List<UUID>,
)


@Serializable()
data class OrderItemsStatusEvent(
    @Serializable(with = UUIDSerialize::class)
    val orderId: UUID,
    @Serializable(with = UUIDSerialize::class)
    val orderItemId: UUID,
    val status: String
)

@Serializable
data class UpdateOrderItemStatusDto(
    @Serializable(with = UUIDSerialize::class)
    val Id: UUID,
    val Status: Int
)
