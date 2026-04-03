package com.example.core.data.repository

import com.example.core.database.Dao.AuthDao
import com.example.core.database.Model.AuthModelEntity
import com.example.core.domain.repository.IDeliveryRepository
import com.example.core.data.dto.DeliveryDto
import com.example.core.domain.Secrets
import com.example.core.network.NetworkCallHandler
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.UnknownHostException
import java.util.UUID

class DeliveryRepository(private val client: HttpClient, private val authDao: AuthDao) :
    IDeliveryRepository {

    private suspend fun getAuthData(): AuthModelEntity? {
        return authDao.getAuthData()
    }

    override suspend fun getDeliveriesBelongToStore(pageNumber: Int): NetworkCallHandler =
        withContext(Dispatchers.IO) {
            val authData =
                getAuthData()
                    ?: return@withContext NetworkCallHandler.Error("user is not authenticate ")

            return@withContext try {
                val result = client.get(
                    Secrets.getUrl() + "/Delivery/all/${pageNumber}"
                ) {
                    headers {
                        append(
                            HttpHeaders.Authorization,
                            "Bearer ${authData.refreshToken}"
                        )
                    }

                    contentType(ContentType.Application.Json)

                }

                when (result.status) {
                    HttpStatusCode.Companion.OK -> {
                        NetworkCallHandler.Successful(result.body<List<DeliveryDto>?>())
                    }

                    else -> {
                        NetworkCallHandler.Error(
                            result.body<String>()
                        )
                    }
                }

            } catch (e: UnknownHostException) {

                return@withContext NetworkCallHandler.Error(e.message)

            } catch (e: IOException) {

                return@withContext NetworkCallHandler.Error(e.message)

            } catch (e: Exception) {

                return@withContext NetworkCallHandler.Error(e.message)
            }
        }

    override suspend fun createNewDelivery(userId: UUID): NetworkCallHandler =
        withContext(Dispatchers.IO) {
            val authData =
                getAuthData()
                    ?: return@withContext NetworkCallHandler.Error("user is not authenticate ")

            return@withContext try {
                val result = client.post(
                    Secrets.getUrl() + "/Delivery/new"
                ) {
                    headers {
                        append(
                            HttpHeaders.Authorization,
                            "Bearer ${authData.refreshToken}"
                        )
                    }
                    setBody(
                        MultiPartFormDataContent(
                            formData {
                                append("UserId", userId.toString())
                            }
                        )
                    )


                }

                when (result.status) {
                    HttpStatusCode.Companion.Created -> {
                        NetworkCallHandler.Successful(result.body<DeliveryDto>())
                    }

                    else -> {
                        NetworkCallHandler.Error(
                            result.body<String>()
                        )
                    }
                }

            } catch (e: UnknownHostException) {

                return@withContext NetworkCallHandler.Error(e.message)

            } catch (e: IOException) {

                return@withContext NetworkCallHandler.Error(e.message)

            } catch (e: Exception) {

                return@withContext NetworkCallHandler.Error(e.message)
            }
        }


}