package com.example.core.domain.repository

import com.example.core.data.dto.UpdateMyInfoDto
import com.example.core.network.NetworkCallHandler

interface IUserRepository {


    suspend fun getMyInfo(): NetworkCallHandler

    suspend fun updateMyInfo(data: UpdateMyInfoDto): NetworkCallHandler

}