package com.example.rentall.screens.auth.registerScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rentall.R
import com.example.rentall.component.ButtonType
import com.example.rentall.component.DefaultButton
import com.example.rentall.component.textfield.DefaultTextField
import com.example.rentall.service.AccountService

@Composable
fun RegisterField() {
    var name by remember { mutableStateOf("") }
    var nik by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirmation by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = { name = it },
            placeholder = "Nama Lengkap"
        )
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = nik,
            onValueChange = { nik = it },
            placeholder = "NIK"
        )
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = { email = it },
            placeholder = "Email"
        )
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = phone,
            onValueChange = { phone = it },
            placeholder = "Nomor Telepon"
        )
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            placeholder = "Password"
        )
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = passwordConfirmation,
            onValueChange = { passwordConfirmation = it },
            placeholder = "Konfirmasi Password"
        )
    }
    RegisterWithGoogle()
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultButton(
            text = "Daftar",
            ButtonType.TEXT,
            buttonColor = Color.White,
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                AccountService.register(name, password){
                        error ->
                    if (error == null) {
                        Log.d("register", "success")
                    } else{
                        Log.d("register", error.toString())
                    }
                }
            }
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

@Composable
fun RegisterWithGoogle() {
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
