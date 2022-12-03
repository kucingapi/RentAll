package com.example.rentall.screens.rentcar

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rentall.component.DateField
import com.example.rentall.component.DefaultButton
import com.example.rentall.component.textfield.DefaultTextField
import com.example.rentall.component.title.Title
import com.example.rentall.screens.auth.navigation.RentRoute
import com.example.rentall.ui.theme.GridMargin
import com.example.rentall.ui.theme.Picton500
import com.example.rentall.ui.theme.RentAllTheme

@Composable
fun Rent(navController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(GridMargin.value.margin),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            var destination by remember { mutableStateOf("")}
            var time by remember { mutableStateOf("")}
            Title(text = "Informasi Penyewaan") {

            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp), verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = "Kemana Anda akan ",
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "pergi?",
                        style = MaterialTheme.typography.h5,
                        color = Picton500,
                        fontWeight = FontWeight.Bold
                    )
                }
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = destination,
                    onValueChange = { destination = it },
                    placeholder = "Tujuan"
                )
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp), verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = "Tanggal ",
                        style = MaterialTheme.typography.h5,
                        color = Picton500,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "dan ",
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Waktu ",
                        style = MaterialTheme.typography.h5,
                        color = Picton500,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Penyewaan ",
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold
                    )
                }
                DateField(
                    Modifier.fillMaxWidth(),
                    time
                ) { time = it }
            }
        }
        Column(Modifier.align(Alignment.BottomCenter)) {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Selanjutnya",
                onClick = {
                    navController.navigate(RentRoute.Payment.route)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RentPreview() {
    RentAllTheme() {
        Rent(rememberNavController())
    }
}