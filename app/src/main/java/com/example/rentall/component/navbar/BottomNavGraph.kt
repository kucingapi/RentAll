package com.example.rentall

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rentall.component.navbar.BottomBarScreen
import com.example.rentall.screens.ChatScreen
import com.example.rentall.screens.HomeScreen

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
            ChatScreen()
        }
        composable(route = BottomBarScreen.Order.route){
            ChatScreen()
        }
        composable(route = BottomBarScreen.Profile.route){
            ChatScreen()
        }
    }
    
}