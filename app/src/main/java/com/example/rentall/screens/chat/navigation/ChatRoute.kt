package com.example.rentall.screens.chat.navigation

sealed class ChatRoute(val route: String) {
    object ChatList : ChatRoute("chat")
    object ChatDetail : ChatRoute("chat/{id}")
}
