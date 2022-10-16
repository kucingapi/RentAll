package com.example.rentall.screens.rentcar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rentall.R
import com.example.rentall.component.DefaultButton
import com.example.rentall.component.button.Padding
import com.example.rentall.component.days.Days
import com.example.rentall.component.title.Title
import com.example.rentall.ui.theme.GridMargin
import com.example.rentall.ui.theme.Picton500
import com.example.rentall.ui.theme.RentAllTheme
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings

@Composable
fun CarDetail() {
    var uiSettings by remember { mutableStateOf(MapUiSettings()) }
    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.SATELLITE))
    }

    Scaffold(
        bottomBar = {FloatingPriceButton()}
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = GridMargin.value.margin)
            .verticalScroll(rememberScrollState())
            ,
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ){
            Title(text = "Detail Mobil") {

            }
            Image(modifier = Modifier
                .padding(top = 60.dp)
                .fillMaxWidth()
                .height(200.dp)
                ,
                painter = painterResource(id = R.drawable.car),
                contentDescription = "gambar mobil",
                contentScale = ContentScale.Fit
            )
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = "Toyota Fortuner", style = MaterialTheme.typography.h4, fontWeight = FontWeight.Bold)
                Text(text = "SUV", style = MaterialTheme.typography.body2, color = Color.Gray)
            }
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = "Penyedia Sewa", style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            modifier = Modifier
                                .size(25.dp)
                                .clip(RoundedCornerShape(100)),
                            painter = painterResource(id = R.drawable.ic_logo),
                            contentDescription = "profile picture",
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "Novel Bafagih",
                            style = MaterialTheme.typography.button,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.ic_message),
                        contentDescription = "message",
                        tint = Picton500
                    )
                }
            }
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = "Detail", style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(30.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CarSpec(text = "6 Orang", image = R.drawable.ic_person)
                        CarSpec(text = "4 Pintu", image = R.drawable.ic_car_door)
                        CarSpec(text = "Matic", image = R.drawable.ic_sttering_wheel)
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(30.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CarSpec(text = "Pendingin Mobil", image = R.drawable.ic_ac)
                        CarSpec(text = "Solar", image = R.drawable.ic_fuel)
                    }
                }
            }
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = "Hari Sewa", style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Days(day = "Senin", active = true)
                        Days(day = "Selasa", active = true)
                        Days(day = "Rabu", active = true)
                        Days(day = "Kamis", active = true)
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Days(day = "Jumaat", active = true)
                        Days(day = "Sabtu", active = true)
                        Days(day = "Minggu", active = true)
                    }
                }
            }
//            GoogleMap(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp),
//                properties = properties,
//                uiSettings = uiSettings
//            )
            DefaultButton(text = "Bayar", modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun CarSpec(text: String, image: Int){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Icon(
            painter = painterResource(id = image),
            tint = Picton500,
            contentDescription = "icon"
        )
        Text(
            text = text,
            style = MaterialTheme.typography.button
        )
    }
}

@Composable
fun FloatingPriceButton() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = GridMargin.value.margin, vertical = 5.dp),
        elevation = 15.dp,
        shape = RoundedCornerShape(16)
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Rp1.000.000 /hari",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
            DefaultButton(
                text = "Sewa",
                paddingInput = Padding(horizontal = 5.dp, vertical = 0.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarDetailPrev() {
    RentAllTheme{
        CarDetail()
    }
}
