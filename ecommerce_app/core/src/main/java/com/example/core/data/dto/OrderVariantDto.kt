package com.example.core.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class OrderVariantDto(
    val variantName:String,
    val name:String
)