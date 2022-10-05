package com.example.rentall.screens.auth

import androidx.compose.foundation.Image
import androidx.navigation.NavHostController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
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
import com.example.rentall.component.DefaultButton
import com.example.rentall.component.button.IconButtonDefault
import com.example.rentall.component.textfield.DefaultTextField
import com.example.rentall.ui.theme.*

@Composable
fun LoginScreen(navController: NavHostController) {
    var text by remember { mutableStateOf("") }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Picton200)
    ){
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = text,
                    onValueChange = { text = it },
                    placeholder = "Email"
                )
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = text,
                    onValueChange = { text = it },
                    placeholder = "Password"
                )
            }
            LoginWithGoogle()
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DefaultButton(
                    text = "Daftar",
                    ButtonType.TEXT,
                    buttonColor = Color.White,
                    modifier = Modifier.fillMaxWidth(),
                )
                Row(){
                    Text(
                        text = "Sudah punya akun?",
                        style = MaterialTheme.typography.subtitle1,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = " Masuk",
                        style = MaterialTheme.typography.subtitle1,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )

                }
            }
        }
    }
}

@Composable
fun LoginWithGoogle() {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(
                Modifier.weight(1f)){
                Divider(
                    color = Color.White,
                    thickness = 1.dp,
                )
            }
            Column(
                Modifier.weight(3f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "atau lanjutkan dengan",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body2
                )
            }
            Column(
                Modifier.weight(1f)){
                Divider(
                    color = Color.White,
                    thickness = 1.dp,
                )
            }
        }
        Image(
            modifier = Modifier.size(45.dp),
            painter = painterResource(id = R.drawable.ic_google_logo),
            contentDescription ="google logo" )
    }
}

@Preview
@Composable
fun LoginPrev() {
    val navController = rememberNavController()
    RentAllTheme {
        LoginScreen(navController = navController)
    }
}
