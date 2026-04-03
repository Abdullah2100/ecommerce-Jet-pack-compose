package com.example.core.data.dto

import kotlinx.serialization.Serializable

@Serializable()
data class GeneralSettingDto(

    val name: String,
    val value: Double
)