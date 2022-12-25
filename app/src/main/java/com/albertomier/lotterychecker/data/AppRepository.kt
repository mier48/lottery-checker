package com.albertomier.lotterychecker.data

import com.albertomier.lotterychecker.data.database.dao.AppDao
import com.albertomier.lotterychecker.data.database.entities.toDatabase
import com.albertomier.lotterychecker.data.network.ApiResponseStatus
import com.albertomier.lotterychecker.data.network.AppService
import com.albertomier.lotterychecker.data.network.makeNetworkCall
import com.albertomier.lotterychecker.domain.model.toDomain
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val appService: AppService,
    private val appDao: AppDao,
) {
    suspend fun checkNumber(number: String): ApiResponseStatus<com.albertomier.lotterychecker.domain.model.Number> =
        makeNetworkCall {
            val response = appService.checkNumber(number = number)

            updateNumber(response.prize, number)

            response.toDomain()
        }

    suspend fun getNumbers(): List<com.albertomier.lotterychecker.domain.model.Number> {
        val response = appDao.getNumbers()

        return response.map { it.toDomain() }
    }

    suspend fun addNumber(number: com.albertomier.lotterychecker.domain.model.Number) =
        appDao.addNumber(number.toDatabase())

    suspend fun removeNumber(number: String) {
        appDao.removeNumber(number)
    }

    private suspend fun updateNumber(prize: Int, number: String) {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val createdAt: String = sdf.format(Date())

        appDao.updateNumber(prize, number, createdAt)
    }
}