package com.example.core.domain.repository

import com.example.core.database.Model.AuthModelEntity
import com.example.core.network.NetworkCallHandler

interface ICategoryRepository {


    suspend fun getCategory(pageNumber: Int): NetworkCallHandler

}