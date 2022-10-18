package com.example.rentall.screens.auth.navigation

sealed class AuthRoute(val route: String) {
    object Splash : RentRoute("splash")
    object Landing : RentRoute("landing")
    object Register : RentRoute("register")
}