package com.example.core.data.repository

import com.example.core.database.Model.AuthModelEntity
import com.example.core.data.dto.CreateOrderDto
import com.example.core.data.dto.OrderDto
import com.example.core.domain.Secrets
import com.example.core.network.NetworkCallHandler
import com.example.core.database.Dao.AuthDao
import com.example.core.domain.repository.IOrderRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
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

class OrderRepository(private val client: HttpClient, private val authDao: AuthDao):
    IOrderRepository {

   private suspend fun getAuthData(): AuthModelEntity? {
        return authDao.getAuthData()
    }

  override  suspend fun submitOrder(cartData: CreateOrderDto): NetworkCallHandler =
        withContext(Dispatchers.IO) {
            val authData =
                getAuthData() ?: return@withContext NetworkCallHandler.Error("user is not authenticate ")

            return@withContext try {
                val fullUrl = Secrets.getUrl() + "/Order"
                val result = client.post(fullUrl) {
                    headers {
                        append(
                            HttpHeaders.Authorization,
                            "Bearer ${authData.refreshToken}"
                        )
                    }
                    contentType(ContentType.Application.Json)
                    setBody(cartData)

                }

                when (result.status) {
                    HttpStatusCode.Companion.Created -> {
                        NetworkCallHandler.Successful(result.body<OrderDto>())
                    }

                    else -> {
                        NetworkCallHandler.Error(result.body<String>())
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

override    suspend fun getMyOrders(pageNumber: Int): NetworkCallHandler = withContext(Dispatchers.IO) {
        val authData =
            getAuthData() ?: return@withContext NetworkCallHandler.Error("user is not authenticate ")

        return@withContext try {
            val fullUrl = Secrets.getUrl() + "/Order/me/${pageNumber}"
            val result = client.get(fullUrl) {
                headers {
                    append(
                        HttpHeaders.Authorization,
                        "Bearer ${authData.refreshToken}"
                    )
                }

            }

            when (result.status) {
                HttpStatusCode.Companion.OK -> {
                    NetworkCallHandler.Successful(result.body<List<OrderDto>>())
                }

                HttpStatusCode.Companion.NoContent -> {
                    NetworkCallHandler.Error("No Data Found")
                }

                else -> {
                    NetworkCallHandler.Error(result.body<String>())
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

  override  suspend fun deleteOrder(orderId: UUID): NetworkCallHandler = withContext(Dispatchers.IO) {
        val authData =
            getAuthData() ?: return@withContext NetworkCallHandler.Error("user is not authenticate ")

        return@withContext try {
            val fullUrl = Secrets.getUrl() + "/Order/${orderId}"
            val result = client.delete(fullUrl) {
                headers {
                    append(
                        HttpHeaders.Authorization,
                        "Bearer ${authData.refreshToken}"
                    )
                }

            }

            when (result.status) {
                HttpStatusCode.Companion.NoContent -> {
                    NetworkCallHandler.Successful(true)
                }

                else -> {
                    NetworkCallHandler.Error(result.body<String>())
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