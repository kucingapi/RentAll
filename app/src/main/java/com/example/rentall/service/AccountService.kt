package com.example.rentall.service

import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AccountService {
    companion object {

        fun register(email: String, password: String, onResult: (Throwable?) -> Unit) {
            Firebase.auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { onResult(it.exception) }
        }

        fun authenticate(email: String, password: String, onResult: (Throwable?) -> Unit) {
            Firebase.auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { onResult(it.exception) }
        }

    }
}