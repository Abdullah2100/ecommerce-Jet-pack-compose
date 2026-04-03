package com.example.core.domain.repository

import com.example.core.data.dto.CreateSubCategoryDto
import com.example.core.data.dto.UpdateSubCategoryDto
import com.example.core.network.NetworkCallHandler
import java.util.UUID

interface ISubCategoryRepository {


    suspend fun createSubCategory(data: CreateSubCategoryDto): NetworkCallHandler

    suspend fun updateSubCategory(data: UpdateSubCategoryDto): NetworkCallHandler


    suspend fun deleteSubCategory(subCategoryID: UUID): NetworkCallHandler


    suspend fun getStoreSubCategory(id: UUID, pageNumber: Int): NetworkCallHandler

}