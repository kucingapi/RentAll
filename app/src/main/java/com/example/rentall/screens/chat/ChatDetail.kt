package com.example.rentall.screens.chat

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rentall.component.title.Title
import com.example.rentall.ui.theme.RentAllTheme
import com.example.rentall.R
import com.example.rentall.ui.theme.Picton500

@Composable
fun ChatDetail(navController: NavHostController): Unit {

    Column(modifier = Modifier.fillMaxSize()){
        Title(modifier = Modifier.padding(bottom = 20.dp),text = "Novel Bafagih") {
            
        }
        Row() {
            Image(
                modifier = Modifier
                    .size(45.dp)
                    .clip(RoundedCornerShape(100)),
                painter = painterResource(id = R.drawable.vania),
                contentDescription = "image",
                contentScale = ContentScale.Crop
            )
            Box(
                Modifier
                    .padding(top = 8.dp) // adding some space to the label
                    .background(
                        Picton500,
                        // rounded corner to match with the OutlinedTextField
                        shape = RoundedCornerShape(4.dp)
                    )
            ) {
                Text(
                    text = "Test",
                    style = MaterialTheme.typography.h6,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatDetailPreview() {
    val navController = rememberNavController()
    RentAllTheme() {
        ChatDetail(navController = navController)
    }
}