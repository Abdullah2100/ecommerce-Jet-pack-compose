package com.example.core.data.dto

import com.example.core.Utils.kSerializeChanger.UUIDSerialize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class OrderProductDto(
    @Serializable(with = UUIDSerialize::class)
    val id: UUID,
    @Serializable(with = UUIDSerialize::class)
    val storeId: UUID,
    val name: String,
    @SerialName("thmbnail")
    val thumbnail: String? = null
)