package com.example.rentall.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rentall.R
import com.example.rentall.ui.theme.RentAllTheme

@Composable
fun ChatSummary(image: Int = R.drawable.ic_logo, title: String, description: String, time:String) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(100)),
            painter = painterResource(id = image),
            contentDescription = "profile picture",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .weight(4f)
                .padding(vertical = 5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    ,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = time,
                    style = MaterialTheme.typography.subtitle1,
                )
            }
            Text(
                text = description,
                color = Color.Gray,
                style = MaterialTheme.typography.body2,
                maxLines = 1
            )
            Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.5.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatSummaryPrev() {
    RentAllTheme() {
        Column(Modifier.fillMaxSize()) {
            ChatSummary(
                title = "Novel Bafagih",
                description = "Untuk kondisi mobilnya baru saja di service",
                time = "17:08"
            )
        }

    }
}
