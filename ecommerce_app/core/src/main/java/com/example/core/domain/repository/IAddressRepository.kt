package com.example.core.domain.repository

import com.example.core.data.dto.CreateAddressDto
import com.example.core.data.dto.UpdateAddressDto
import com.example.core.network.NetworkCallHandler
import java.util.UUID

interface IAddressRepository {



    suspend fun userAddNewAddress(locationData: CreateAddressDto): NetworkCallHandler
    suspend fun userUpdateAddress(locationData: UpdateAddressDto): NetworkCallHandler

    suspend fun deleteUserAddress(addressID: UUID): NetworkCallHandler

    suspend fun setAddressAsCurrent(addressId: UUID): NetworkCallHandler

    suspend fun getStoreAddress(id: UUID, pageNumber: Int): NetworkCallHandler

}