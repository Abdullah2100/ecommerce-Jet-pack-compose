package com.example.core.domain.model

import java.util.UUID

data class ProductVariantSelection(
    val name: String,
    val percentage: Int?,
    val variantId: UUID,
    )
