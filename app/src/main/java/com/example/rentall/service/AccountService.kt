package com.example.rentall.service

import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AccountService {
    companion object {
        fun register(
            email: String,
            password: String,
            onSucess: () -> Unit,
            onFailure: (Exception) -> Unit
        ) {
            Firebase.auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    onSucess()
                }
                .addOnFailureListener{
                    onFailure(it)
                }
        }
        fun signOut(){
            Firebase.auth.signOut()
        }
        fun authenticate(
            email: String,
            password: String,
            onSucess: () -> Unit,
            onFailure: (Exception) -> Unit
        ) {
            Firebase.auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    onSucess()
                }
                .addOnFailureListener{
                    onFailure(it)
                }
        }
    }
}