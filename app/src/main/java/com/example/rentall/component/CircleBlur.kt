package com.example.rentall.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.rentall.R

@Composable
fun CircleBlur(
    alpha: Float,
    contentScale: ContentScale,
    width: Dp = 450.dp,
    height: Dp = 450.dp
) {
    Image(
        modifier = Modifier
            .width(width)
            .height(height)
            .alpha(alpha = alpha),
        painter = painterResource(id = R.drawable.img_bubble_blur),
        contentDescription = "Circle blur",
        contentScale = contentScale
    )
}