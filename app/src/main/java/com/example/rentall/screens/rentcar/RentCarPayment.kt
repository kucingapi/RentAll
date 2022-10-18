package com.example.rentall.screens.rentcar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rentall.R
import com.example.rentall.component.DefaultButton
import com.example.rentall.ui.theme.GridMargin
import com.example.rentall.ui.theme.RentAllTheme

@Composable
fun RentCarPayment() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = GridMargin.value.margin, vertical = 80.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ){
        Image(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            ,
            painter = painterResource(id = R.drawable.car),
            contentDescription = "gambar mobil",
            contentScale = ContentScale.Fit
        )
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "Toyota Fortuner", style = MaterialTheme.typography.h4, fontWeight = FontWeight.Bold)
            Text(text = "SUV", style = MaterialTheme.typography.body2, color = Color.Gray)
        }
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "Tanggal Sewa", style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)){
                Icon(painter = painterResource(id = R.drawable.ic_date), contentDescription ="date")
                Text(text = "29/08/2022 - 30/08/2022", style = MaterialTheme.typography.button)
            }
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Rp. 100.000",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End
        )
        DefaultButton(text = "Bayar", modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun RentCarPrev() {
    RentAllTheme{
        RentCarPayment()
    }
}