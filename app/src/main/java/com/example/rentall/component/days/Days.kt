package com.example.rentall.component.days

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rentall.ui.theme.Picton100
import com.example.rentall.ui.theme.Picton500
import com.example.rentall.ui.theme.RentAllTheme

@Composable
fun Days(day: String, active: Boolean) {
    val backgroundColor: Color =
        if(active)
            Picton500
        else
            Picton100
    val color: Color =
        if(active)
            Color.White
        else
            Picton500
    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Card(modifier = Modifier.size(70.dp),
            shape = RoundedCornerShape(100),
            backgroundColor = backgroundColor,
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(
                    modifier = Modifier.padding(bottom = 5.dp),
                    text = day.first().uppercase(),
                    style = MaterialTheme.typography.h1,
                    fontWeight = FontWeight.Bold,
                    color = color
                )
            }
        }
        Text(
            modifier = Modifier.padding(bottom = 5.dp),
            text = day,
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DaysPrev() {
    RentAllTheme {
        Column(modifier = Modifier.fillMaxSize()){
            Days("Rabu", active = true)
            Days("Jumaat", active = false)
        }
    }
}