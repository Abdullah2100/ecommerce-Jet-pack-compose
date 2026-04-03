package com.example.core.domain.repository


import com.example.core.network.NetworkCallHandler


interface IGeneralSettingRepository {

    suspend fun getGeneral(pageNumber: Int): NetworkCallHandler

}