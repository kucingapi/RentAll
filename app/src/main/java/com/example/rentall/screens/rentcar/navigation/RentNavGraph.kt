package com.example.rentall.screens.auth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rentall.screens.auth.LandingScreen
import com.example.rentall.screens.auth.RegisterScreen
import com.example.rentall.screens.auth.SplashScreen
import com.example.rentall.screens.rentcar.CarDetail
import com.example.rentall.screens.rentcar.Rent
import com.example.rentall.screens.rentcar.RentCarPayment

@Composable
fun RentNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = RentRoute.Detail.route
    ) {
        composable(route = RentRoute.Detail.route) {
            CarDetail(navController)
        }
        composable(route = RentRoute.Rent.route) {
            Rent(navController)
        }
        composable(route = RentRoute.Payment.route) {
            RentCarPayment(navController)
        }
    }
}