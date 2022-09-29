package com.example.rentall.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rentall.R
import com.example.rentall.ui.theme.Picton700
import com.example.rentall.ui.theme.RentAllTheme

@Composable
fun CardTour(paintId: Int = R.drawable.img_wisata_monas,
             title: String = "Monas",
             description: String = "Monas adalah monumen nasional di jakarta yang sering",

){
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Image(painter = painterResource(id = R.drawable.img_wisata_background),
            contentDescription ="background",
            modifier = Modifier
                .height(215.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )
        Card(
            shape = RoundedCornerShape(12),
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .height(180.dp)
                .fillMaxWidth(),
        ) {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter) {
                Image(
                    painter = painterResource(id = paintId),
                    contentDescription = "tempat wisata",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Picton700.copy(0.7f)))
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(15.dp), verticalAlignment = Alignment.Bottom) {
                    Column(Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        Text(text = title,
                            style = MaterialTheme.typography.h3,
                            color = Color.White,
                            fontWeight = FontWeight.Bold)
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .height(2.dp)
                                .background(Color.White))
                        Text(text = description,
                            style = MaterialTheme.typography.body2,
                            color = Color.White,
                            maxLines = 2,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                    Box(Modifier.weight(1f), contentAlignment = Alignment.BottomEnd){
                        Row(verticalAlignment =  Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Icon(painter = painterResource(id = R.drawable.ic_location),
                                contentDescription = "icon location",
                                tint = MaterialTheme.colors.primary,
                                modifier = Modifier.size(45.dp)
                            )
                            Text(text = "1 km",
                                style = MaterialTheme.typography.h4,
                                color = Color.White,
                                fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun defaultCardTour(){
    RentAllTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            CardTour()
        }
    }
}
