package com.example.rentall.screens.chat.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.rentall.screens.chat.ChatDetail
import com.example.rentall.screens.chat.ChatList

@Composable
fun ChatNavGraph (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = ChatRoute.ChatList.route
    ) {
        composable(route = ChatRoute.ChatList.route) {
            ChatList(navController = navController)
        }
        composable(route = ChatRoute.ChatDetail.route) {
            ChatDetail(navController = navController)
        }
    }
}