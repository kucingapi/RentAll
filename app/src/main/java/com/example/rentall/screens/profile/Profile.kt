package com.example.rentall.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rentall.R
import com.example.rentall.ui.theme.RentAllTheme

@Composable
fun ProfileScreen(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()){
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.ic_half_circle),
            contentDescription = "half circle",
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.padding(horizontal = 18.dp, vertical = 36.dp)) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(48.dp)
            ) {
                Text(
                    text = "Profil",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold
                    )
                Image(
                    painter = painterResource(id = R.drawable.vania),
                    contentDescription = "profile picture",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clip(RoundedCornerShape(100)),
                    contentScale = ContentScale.Crop,
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfile() {
    RentAllTheme {
        ProfileScreen(rememberNavController());
    }
}