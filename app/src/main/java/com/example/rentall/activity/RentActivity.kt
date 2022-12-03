package com.example.rentall.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.rentall.screens.auth.navigation.AuthNavGraph
import com.example.rentall.screens.auth.navigation.RentNavGraph
import com.example.rentall.ui.theme.RentAllTheme

class RentActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RentAllTheme {
                val navController = rememberNavController()
                RentNavGraph(navController = navController)
            }
        }
    }
}
