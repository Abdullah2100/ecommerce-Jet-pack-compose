package com.example.core.data.dto

import com.example.core.Utils.kSerializeChanger.UUIDSerialize
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class CategoryDto(
    @Serializable(with = UUIDSerialize::class)
    val id: UUID,
    val name: String,
    val image: String
)