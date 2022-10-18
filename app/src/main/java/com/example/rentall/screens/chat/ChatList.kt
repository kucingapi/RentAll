package com.example.rentall.screens.chat

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rentall.component.ChatSummary
import com.example.rentall.component.textfield.DefaultTextField
import com.example.rentall.component.title.Title
import com.example.rentall.ui.theme.GridMargin
import com.example.rentall.ui.theme.RentAllTheme


@Composable
fun ChatList(navController: NavHostController ): Unit {
    var text by remember { mutableStateOf("") }
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = GridMargin.value.margin, vertical = 15.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Title(text = "Pesan"){

        }
        DefaultTextField(modifier = Modifier.fillMaxWidth(),value = text, onValueChange = {text = it}, placeholder = "Cari")
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ChatSummary(
                title = "Novel Bafagih",
                description = "Untuk kondisi mobilnya baru saja di service",
                time = "17:08"
            )
            ChatSummary(
                title = "Novel Bafagih",
                description = "Untuk kondisi mobilnya baru saja di service",
                time = "17:08"
            )
            ChatSummary(
                title = "Novel Bafagih",
                description = "Untuk kondisi mobilnya baru saja di service",
                time = "17:08"
            )
            ChatSummary(
                title = "Novel Bafagih",
                description = "Untuk kondisi mobilnya baru saja di service",
                time = "17:08"
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatListPrev() {
    val navController = rememberNavController()
    RentAllTheme {
        ChatList(navController = navController)
    }
}
