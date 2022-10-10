package com.example.rentall.screens.auth.navigation

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rentall.screens.auth.LandingScreen
import com.example.rentall.screens.auth.RegisterScreen
import com.example.rentall.screens.auth.SplashScreen

@Composable
fun AuthNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AuthRoute.Splash.route
    ) {
        composable(route = AuthRoute.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = AuthRoute.Landing.route) {
            LandingScreen(navController = navController)
        }
        composable(route = AuthRoute.Register.route) {
            RegisterScreen(navController = navController)
        }
    }
}