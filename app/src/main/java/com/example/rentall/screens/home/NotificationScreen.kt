package com.example.rentall.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rentall.component.statutreq.Statbar
import com.example.rentall.component.title.Title
import com.example.rentall.ui.theme.GridMargin
import com.example.rentall.ui.theme.RentAllTheme

@Composable
fun NotificationScreen(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(GridMargin.value.margin),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Title(text = "Notifikasi", button = false) {

        }
        Statbar()
    }
}

@Preview(showBackground = true)
@Composable
fun NotPrev() {
    RentAllTheme() {
        NotificationScreen(rememberNavController())
    }
}