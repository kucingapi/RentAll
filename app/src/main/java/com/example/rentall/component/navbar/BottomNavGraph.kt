package com.example.rentall

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rentall.component.navbar.BottomBarScreen
import com.example.rentall.screens.HomeScreen
import com.example.rentall.screens.chat.ChatList

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Chat.route){
            ChatList(navController = navController)
        }
        composable(route = BottomBarScreen.Order.route){
        }
        composable(route = BottomBarScreen.Profile.route){
        }
    }
    
}