package com.example.core.data.dto

import com.example.core.Utils.kSerializeChanger.UUIDSerialize
import kotlinx.serialization.Serializable
import java.util.UUID


@Serializable
data class CurrencyDto(
    @Serializable(with = UUIDSerialize::class)
    var id: UUID,
    var name: String,
    var symbol: String,
    var value: Int,
    var isDefault: Boolean
)
