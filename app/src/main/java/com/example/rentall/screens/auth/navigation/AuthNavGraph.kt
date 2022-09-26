package com.example.rentall.screens.auth.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
            Box(modifier = Modifier.fillMaxSize())
        }
    }
}