package com.example.core.domain.repository

import com.example.common.model.ProductVariantSelection
import com.example.core.network.NetworkCallHandler
import java.io.File
import java.util.UUID

interface IProductRepository {


    suspend fun getProduct(pageNumber: Int): NetworkCallHandler
    suspend fun getProductByCategoryId(
        categoryId: UUID,
        pageNumber: Int
    ): NetworkCallHandler

    suspend fun getProduct(storeId: UUID, pageNumber: Int): NetworkCallHandler

    suspend fun getProduct(
        storeId: UUID,
        subCategory: UUID,
        pageNumber: Int
    ): NetworkCallHandler


    suspend fun createProduct(
        name: String,
        description: String,
        thumbnail: File,
        subcategoryId: UUID,
        storeId: UUID,
        price: Int,
        symbol: String,
        productVariants: List<ProductVariantSelection>,
        images: List<File>
    ): NetworkCallHandler

    suspend fun updateProduct(
        id: UUID,
        name: String?,
        description: String?,
        thumbnail: File?,
        subcategoryId: UUID?,
        storeId: UUID,
        price: Int?,
        symbol: String?,
        productVariants: List<ProductVariantSelection>?,
        images: List<File>?,
        deletedProductVariants: List<ProductVariantSelection>?,
        deleteImages: List<String>?
    ): NetworkCallHandler

    suspend fun deleteProduct(storeId: UUID, productId: UUID): NetworkCallHandler

}