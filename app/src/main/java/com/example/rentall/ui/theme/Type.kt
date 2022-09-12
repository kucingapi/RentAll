package com.example.rentall.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.rentall.R

private val Satoshi = FontFamily(
    Font(R.font.satoshilight, FontWeight(300)),
    Font(R.font.satoshiregular, FontWeight(400)),
    Font(R.font.satoshimedium, FontWeight(500)),
    Font(R.font.satoshibold, FontWeight(600))
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 43.sp
    ),
    h2 = TextStyle(
        fontFamily = Satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    ),
    h3 = TextStyle(
        fontFamily = Satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 27.sp
    ),
    h4 = TextStyle(
        fontFamily = Satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 21.sp
    ),
    h5 = TextStyle(
        fontFamily = Satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 19.sp
    ),
    body1 = TextStyle(
        fontFamily = Satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 21.sp
    ),
    body2 = TextStyle(
        fontFamily = Satoshi,
        fontWeight = FontWeight.Normal,
        fontSize = 19.sp
    ),
    button = TextStyle(
        fontFamily = Satoshi,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    /* Other default text styles to override
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)