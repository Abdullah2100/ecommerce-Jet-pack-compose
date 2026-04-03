package com.example.core.data.dto

import com.example.core.Utils.kSerializeChanger.UUIDSerialize
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class SubCategoryDto(
    val name: String,
    @Serializable(with = UUIDSerialize::class)
    val id: UUID,
    @Serializable(with = UUIDSerialize::class)
    val storeId: UUID,
    @Serializable(with = UUIDSerialize::class)
    val categoryId: UUID,
)


@Serializable
data class UpdateSubCategoryDto(
    val name: String,
    @Serializable(with = UUIDSerialize::class)
    val id: UUID,
    @Serializable(with = UUIDSerialize::class)
    val categoryId: UUID
)

@Serializable
data class CreateSubCategoryDto(
    val Name: String,
    @Serializable(with = UUIDSerialize::class)
    val CategoryId: UUID
)

