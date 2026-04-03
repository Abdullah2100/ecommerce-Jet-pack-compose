package com.example.core.data.dto

import com.example.core.Utils.kSerializeChanger.UUIDSerialize
import java.util.UUID
import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    @Serializable(with= UUIDSerialize::class)
    val id: UUID,
    val name: String,
    val description:String,
      //
    val thumbnail:String,
    @Serializable(with = UUIDSerialize::class)
    val subcategoryId: UUID,
    @Serializable(with = UUIDSerialize::class)
    val storeId: UUID,
    @Serializable(with = UUIDSerialize::class)
    val categoryId: UUID,
    val price: Int,
    val symbol: String,
    val productVariants:List<List<ProductVariantDto>>?=null,
    val productImages:List<String>
)