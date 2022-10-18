package com.example.rentall.screens.auth

import android.util.Log
import androidx.compose.foundation.Image
import androidx.navigation.NavHostController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.rentall.R
import com.example.rentall.component.ButtonType
import com.example.rentall.component.CircleBlur
import com.example.rentall.component.DefaultButton
import com.example.rentall.component.textfield.DefaultTextField
import com.example.rentall.screens.auth.registerScreen.RegisterField
import com.example.rentall.ui.theme.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun RegisterScreen(navController: NavHostController) {

    val circleSize = 450.dp
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Picton200)
    ){
        Box(modifier = Modifier
            .align(Alignment.TopEnd)
            .offset(x = 180.dp, y = (-150).dp)){
            CircleBlur(
                contentScale = ContentScale.FillBounds,
                width = circleSize,
                height = circleSize
            )
        }
        Box(modifier = Modifier
            .align(Alignment.BottomStart)
            .offset(y = 180.dp, x = (-150).dp)){
            CircleBlur(
                contentScale = ContentScale.FillBounds,
                width = circleSize,
                height = circleSize
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = GridMargin.value.margin, vertical = 10.dp)
                .verticalScroll(rememberScrollState())
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo_text_vertical),
                modifier = Modifier.size(130.dp),
                contentDescription = "car and money",
                contentScale = ContentScale.Fit
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Text(
                    text = "Daftarkan diri Anda",
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Masukkan informasi-informasi Anda",
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center,
                )
            }
            RegisterField(navController)
        }
    }
}



@Preview
@Composable
fun RegisterPrev() {
    val navController = rememberNavController()
    RentAllTheme {
        RegisterScreen(navController = navController)
    }
}
