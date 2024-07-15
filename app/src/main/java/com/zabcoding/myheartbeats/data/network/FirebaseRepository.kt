package com.zabcoding.myheartbeats.data.network

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.zabcoding.myheartbeats.data.network.dto.SignInDto
import com.zabcoding.myheartbeats.data.network.dto.SignUpDto
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseRepository @Inject constructor(
    private val database: FirebaseDatabase,
    private val authentication: FirebaseAuth
) {

    suspend fun signIn(signIn: SignInDto): FirebaseUser? {
        return authentication.signInWithEmailAndPassword(
            signIn.email,
            signIn.password
        ).await().user
    }

    suspend fun signUp(signUp: SignUpDto): FirebaseUser? {
        return authentication.createUserWithEmailAndPassword(
            signUp.email,
            signUp.password
        ).await().user
    }

    fun sendResetPasswordEmail(email: String): Boolean? {
        var response: Boolean? = null
        authentication.sendPasswordResetEmail(email)
            .addOnCompleteListener { response = it.isSuccessful }
        return response
    }

    fun getCurrentUser(): String? {
        return authentication.currentUser?.email
    }

    fun logout() {
        authentication.signOut()
    }

    suspend fun getECGData() {

    }

}