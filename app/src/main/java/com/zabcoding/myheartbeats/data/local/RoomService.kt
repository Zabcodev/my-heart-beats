package com.zabcoding.myheartbeats.data.local

import com.zabcoding.myheartbeats.data.local.dao.EcgDao
import com.zabcoding.myheartbeats.data.local.entities.EcgEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomService @Inject constructor(
    private val dao: EcgDao
) {

    suspend fun insertData(ecgData: EcgEntity) = dao.insertData(ecgData)

    fun getDataForDiagram() = dao.getEcgData()

    suspend fun deleteData() = dao.deleteData()

}