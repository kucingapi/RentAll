package com.example.rentall.component.navbar

import com.example.rentall.R

sealed class BottomBarScreen (val route: String,
                              val title: String,
                              val icon: Int){
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home_outline
    )
    object Chat : BottomBarScreen(
        route = "chat",
        title = "Chat",
        icon = R.drawable.ic_message
    )
    object Order : BottomBarScreen(
        route = "order",
        title = "Order",
        icon = R.drawable.ic_request
    )
    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.ic_profile_circle_outline
    )

}