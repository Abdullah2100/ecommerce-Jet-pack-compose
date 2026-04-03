package com.example.core.data.repository


import com.example.core.database.Dao.AuthDao
import com.example.core.database.Model.AuthModelEntity
import com.example.core.domain.repository.IGeneralSettingRepository
import com.example.core.data.dto.GeneralSettingDto
import com.example.core.domain.Secrets
import com.example.core.network.NetworkCallHandler
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.UnknownHostException

class GeneralSettingRepository(private val client: HttpClient, private val authDao: AuthDao):
    IGeneralSettingRepository {

   private suspend fun getAuthData(): AuthModelEntity? {
        return authDao.getAuthData()
    }

    override suspend fun getGeneral(pageNumber: Int): NetworkCallHandler = withContext(Dispatchers.IO) {
        val authData =
            getAuthData() ?: return@withContext NetworkCallHandler.Error("user is not authenticate ")

        return@withContext try {
            val result = client.get(
                Secrets.getUrl() + "/General/all/${pageNumber}"
            ) {
                headers {
                    append(
                        HttpHeaders.Authorization,
                        "Bearer ${authData.refreshToken}"
                    )
                }
            }
            when (result.status) {
                HttpStatusCode.Companion.OK -> {
                    NetworkCallHandler.Successful(result.body<List<GeneralSettingDto>>())
                }

                HttpStatusCode.Companion.NoContent -> {
                    NetworkCallHandler.Error("No Data Found")

                }

                else -> {
                    NetworkCallHandler.Error(result.body())
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