package com.zabcoding.myheartbeats.data.network

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.snapshots
import com.zabcoding.myheartbeats.data.network.dto.SignInDto
import com.zabcoding.myheartbeats.data.network.dto.SignUpDto
import com.zabcoding.myheartbeats.data.network.response.EcgResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseRepository @Inject constructor(
    private val reference: DatabaseReference,
    private val authentication: FirebaseAuth
) {

    companion object {
        const val ECG_PATH = "ECG"
    }

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

    fun getECGData(): Flow<EcgResponse> {
        return reference.database.reference.child(ECG_PATH).snapshots.mapNotNull { dataSnapshot ->
            dataSnapshot.getValue(EcgResponse::class.java)
        }
    }
}