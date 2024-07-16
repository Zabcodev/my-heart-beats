package com.zabcoding.myheartbeats.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zabcoding.myheartbeats.data.local.dao.EcgDao
import com.zabcoding.myheartbeats.data.local.entities.EcgEntity

@Database(
    entities = [EcgEntity::class],
    version = 1,
    exportSchema = false
)
abstract class EcgDatabase : RoomDatabase() {
    abstract val ecgDao: EcgDao
}