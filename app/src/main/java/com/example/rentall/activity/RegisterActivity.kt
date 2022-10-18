package com.example.rentall.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.rentall.screens.auth.navigation.AuthNavGraph
import com.example.rentall.ui.theme.RentAllTheme

class RegisterActivity : AppCompatActivity() {
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