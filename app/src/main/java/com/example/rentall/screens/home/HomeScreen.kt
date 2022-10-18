package com.example.rentall.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rentall.R
import com.example.rentall.component.ButtonSize
import com.example.rentall.component.ButtonType
import com.example.rentall.component.DefaultButton
import com.example.rentall.component.textfield.DefaultTextField
import com.example.rentall.ui.theme.GridMargin

@Composable
fun HomeScreen() {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = GridMargin.value.margin)) {
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
            Column(verticalArrangement = Arrangement.spacedBy(1.dp)) {
                Text(
                    text = "Hi, Vania",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Mau rental mobil apa, nih?",
                    style = MaterialTheme.typography.body2,
                    color = Color.Gray
                )
            }
            Image(
                contentScale = ContentScale.Crop, modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape), painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "gambar mobil"
            )
        }
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { text = it },
            placeholder = "Cari kendaraan"
        )
        Row (modifier = Modifier.fillMaxWidth()){
            DefaultButton(text = "Mobil", buttonType = ButtonType.PRIMARY, size= ButtonSize.SMALL)
            DefaultButton(text = "Motor", buttonType = ButtonType.OUTLINE, size=ButtonSize.SMALL)
            DefaultButton(text = "Matic", buttonType = ButtonType.OUTLINE, size=ButtonSize.SMALL)
        }
        Text(
            text = "Dengan dengan lokasi anda",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        HomeScreen()
    }
}
