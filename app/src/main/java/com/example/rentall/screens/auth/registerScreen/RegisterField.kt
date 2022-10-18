package com.example.rentall.screens.auth.registerScreen

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.rentall.R
import com.example.rentall.activity.RentActivity
import com.example.rentall.component.ButtonType
import com.example.rentall.component.DefaultButton
import com.example.rentall.component.textfield.DefaultTextField
import com.example.rentall.screens.auth.navigation.AuthRoute
import com.example.rentall.service.AccountService
import com.example.rentall.service.functions.FunctionUserService

@Composable
fun RegisterField(navController: NavHostController) {
    var name by remember { mutableStateOf("novel bafagih") }
    var nik by remember { mutableStateOf("2314") }
    var email by remember { mutableStateOf("novelb@gmail.com") }
    var phone by remember { mutableStateOf("12831") }
    var password by remember { mutableStateOf("12345678") }
    var passwordConfirmation by remember { mutableStateOf("12345678") }
    val context = LocalContext.current

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
            placeholder = "Password",
            password = true
        )
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = passwordConfirmation,
            onValueChange = { passwordConfirmation = it },
            placeholder = "Konfirmasi Password",
            password = true
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
                createUser(
                    email,
                    password,
                    nik,
                    phone,
                    name,
                    context,
                    passwordConfirmation
                )
            }
        )
        Row(){
            Text(
                text = "Sudah punya akun? ",
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = Modifier.clickable {
                    navController.navigate(AuthRoute.Login.route)
                },
                text = "Masuk",
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

fun createUser(
    email: String,
    password: String,
    nik: String,
    phone: String,
    name: String,
    context: Context,
    passwordConfirmation: String
) {
    if(password != passwordConfirmation){
        mToast(context, "Password konfirmasi harus sama")
    }
    AccountService.register(
        email,
        password,
        onFailure = {
            mToast(context, "User Failed, there has been an Error")
        },
        onSucess = {
            FunctionUserService.registerAllUserData(
                name,
                nik,
                phone,
                onSuccess = {
                    mToast(context, "User has been created")

                },
                onFailure = {
                    mToast(context, "User Failed, there has been an Error")
                }
            )
        }
    )
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
            contentDescription ="google logo"
        )
    }
}

fun mToast(context: Context, message: String){
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}
