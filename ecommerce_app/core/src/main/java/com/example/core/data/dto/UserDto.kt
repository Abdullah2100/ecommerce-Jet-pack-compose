package com.example.core.data.dto

import com.example.core.Utils.kSerializeChanger.UUIDSerialize
import kotlinx.serialization.Serializable
import java.util.UUID


@Serializable
data class UserDto(
    @Serializable(with = UUIDSerialize::class)
    val id: UUID,
    val name:String,
    val phone: String,
    val email: String,
    val thumbnail:String,
    val address: List<AddressDto>?=null,
    @Serializable(with = UUIDSerialize::class)
    val storeId: UUID?=null,
)
