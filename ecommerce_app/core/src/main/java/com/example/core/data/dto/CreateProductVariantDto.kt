package com.example.core.data.dto

import com.example.core.Utils.kSerializeChanger.UUIDSerialize
import java.util.UUID
import kotlinx.serialization.Serializable


@Serializable()
data class ProductVariantDto(
    @Serializable(with = UUIDSerialize::class)
    val id: UUID,
    val name: String,
    val percentage: Int,
    @Serializable(with = UUIDSerialize::class)
    val variantId: UUID,
)

@Serializable
data class CreateProductVariantDto(
    val Name: String,
    val Percentage: Int?,
    @Serializable(with= UUIDSerialize::class)
    val VariantId: UUID,
)
