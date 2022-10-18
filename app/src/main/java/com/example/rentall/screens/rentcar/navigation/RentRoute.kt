package com.example.rentall.screens.auth.navigation

sealed class RentRoute(val route: String) {
    object Detail : RentRoute("detail")
    object Rent : RentRoute("rent")
    object Payment  : RentRoute("payment")
}