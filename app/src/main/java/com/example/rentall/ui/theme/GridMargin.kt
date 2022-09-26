package com.example.rentall.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class GridMargin(val margin: Dp) {
    object value: GridMargin (20.dp)
}
