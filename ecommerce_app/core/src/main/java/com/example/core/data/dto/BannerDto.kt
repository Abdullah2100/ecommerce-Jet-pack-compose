package com.example.core.data.dto

import com.example.core.Utils.kSerializeChanger.UUIDSerialize
import kotlinx.serialization.Serializable
import java.io.File
import java.util.UUID

@Serializable
data class BannerDto(
    @Serializable(with = UUIDSerialize::class)
    val id: UUID,
    val image: String,
    @Serializable(with = UUIDSerialize::class)
    val storeId: UUID,
)


data class CreateBannerDto(
    val Image: File,
    @Serializable(with = UUIDSerialize::class)
    val StoreId: UUID
)