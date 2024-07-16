package com.zabcoding.myheartbeats.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.zabcoding.myheartbeats.data.network.FirebaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideFirebaseAuthentication() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseDatabase() = Firebase.database.reference

    @Provides
    @Singleton
    fun provideFirebaseRepository(
        databaseReference: DatabaseReference,
        authentication: FirebaseAuth
    ) = FirebaseRepository(reference = databaseReference, authentication = authentication)


}