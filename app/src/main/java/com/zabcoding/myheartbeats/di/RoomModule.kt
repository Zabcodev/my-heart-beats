package com.zabcoding.myheartbeats.di

import android.content.Context
import androidx.room.Room
import com.zabcoding.myheartbeats.data.local.RoomService
import com.zabcoding.myheartbeats.data.local.dao.EcgDao
import com.zabcoding.myheartbeats.data.local.db.EcgDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, EcgDatabase::class.java, "ecg_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideEcgDao(db: EcgDatabase) = db.ecgDao

    @Provides
    @Singleton
    fun provideRoomService(dao: EcgDao) = RoomService(dao = dao)
}