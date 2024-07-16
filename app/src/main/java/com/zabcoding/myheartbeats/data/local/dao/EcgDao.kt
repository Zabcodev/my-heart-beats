package com.zabcoding.myheartbeats.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.zabcoding.myheartbeats.data.local.entities.EcgEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EcgDao {

    @Insert
    suspend fun insertData(ecgData: EcgEntity)

    @Query("SELECT * FROM ecg_data")
    fun getEcgData(): Flow<List<EcgEntity>>

    @Query("DELETE FROM ecg_data")
    suspend fun deleteData()

}