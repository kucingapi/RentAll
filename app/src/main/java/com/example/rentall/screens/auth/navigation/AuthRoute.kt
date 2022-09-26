package com.example.rentall.screens.auth.navigation

sealed class AuthRoute(val route: String) {
    object Splash : AuthRoute("splash_screen")
    object Landing : AuthRoute("landing_screen")
}