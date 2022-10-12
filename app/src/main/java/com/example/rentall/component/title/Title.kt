package com.example.rentall.component.title

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rentall.R
import com.example.rentall.component.ButtonSize
import com.example.rentall.component.button.IconButtonDefault
import com.example.rentall.ui.theme.RentAllTheme

@Composable
fun Title(text: String, onClick:() -> Unit ) {
    Box(modifier = Modifier.fillMaxWidth()){

        IconButtonDefault(
            onClick = onClick,
            size=ButtonSize.SMALL,
            iconId = R.drawable.ic_arrow_left,
            modifier = Modifier.align(Alignment.TopStart),
            contentPadding = 7.dp
        )
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = text,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TitlePrev() {
    RentAllTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            Title("Pesan", {})
        }
    }
}