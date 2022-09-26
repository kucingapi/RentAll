package com.example.rentall.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rentall.R
import com.example.rentall.ui.theme.Picton200

@Composable
fun SplashScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Picton200),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.align(Alignment.TopEnd).offset(x = 180.dp,y = (-150).dp)){
            Image(
                modifier = Modifier.width(450.dp).height(450.dp),
                painter = painterResource(id = R.drawable.img_bubble_blur),
                contentDescription = "logo vertical",
                contentScale = ContentScale.FillBounds

            )
        }
        Box(modifier = Modifier.align(Alignment.BottomStart).offset(y = 180.dp,x = (-150).dp)){
            Image(
                modifier = Modifier.width(450.dp).height(450.dp),
                painter = painterResource(id = R.drawable.img_bubble_blur),
                contentDescription = "logo vertical",
                contentScale = ContentScale.FillBounds

            )
        }
        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(id = R.drawable.ic_logo_text_vertical),
            contentDescription = "logo vertical"
        )
    }
}

@Preview
@Composable
fun SplashPrev() {
    SplashScreen()
}