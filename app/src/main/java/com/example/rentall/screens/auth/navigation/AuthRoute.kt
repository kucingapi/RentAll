package com.example.rentall.screens.auth.navigation

sealed class AuthRoute(val route: String) {
    object Splash : AuthRoute("splash")
    object Landing : AuthRoute("landing")
    object Register : AuthRoute("register")
}