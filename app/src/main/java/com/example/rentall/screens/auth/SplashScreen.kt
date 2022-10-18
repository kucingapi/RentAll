package com.example.rentall.screens.auth

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rentall.R
import com.example.rentall.component.CircleBlur
import com.example.rentall.screens.auth.navigation.RentRoute
import com.example.rentall.ui.theme.Picton200
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )
    val circleSize = 450.dp
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(RentRoute.Landing.route)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Picton200),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier
            .align(Alignment.TopEnd)
            .offset(x = 180.dp, y = (-150).dp)){
            CircleBlur(
                alpha = alphaAnim.value,
                contentScale = ContentScale.FillBounds,
                width = circleSize,
                height = circleSize
            )
        }
        Box(modifier = Modifier
            .align(Alignment.BottomStart)
            .offset(y = 180.dp, x = (-150).dp)){
            CircleBlur(
                alpha = alphaAnim.value,
                contentScale = ContentScale.FillBounds,
                width = circleSize,
                height = circleSize
            )
        }
        Image(
            modifier = Modifier
                .size(150.dp)
                .alpha(alpha = alphaAnim.value),
            painter = painterResource(id = R.drawable.ic_logo_text_vertical),
            contentDescription = "logo vertical"
        )
    }
}

@Preview
@Composable
fun SplashPrev() {
    val navController = rememberNavController()
    SplashScreen(navController = navController)
}