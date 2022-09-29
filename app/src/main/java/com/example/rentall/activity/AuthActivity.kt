package com.example.rentall.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.rentall.screens.auth.navigation.AuthNavGraph
import com.example.rentall.ui.theme.Picton500
import com.example.rentall.ui.theme.RentAllTheme

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RentAllTheme {
                val navController = rememberNavController()
                AuthNavGraph(navController = navController)
            }
        }
    }
}