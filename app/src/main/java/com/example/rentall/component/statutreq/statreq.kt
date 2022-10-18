package com.example.rentall.component.statutreq


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
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
import androidx.compose.ui.unit.sp
import com.example.rentall.R
import com.example.rentall.component.days.Days
import com.example.rentall.ui.theme.*

@Composable
fun Statbar() {
    Column(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
                modifier = Modifier
                    .fillMaxWidth()
            ,
                shape = RoundedCornerShape(100),
                backgroundColor = Picton50,
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                , contentAlignment = Alignment.TopStart) {
                Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                    Card(
                            modifier = Modifier.size(70.dp),
                            shape = RoundedCornerShape(100),
                            backgroundColor = Picton200
                    ) {
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Icon(
                                modifier = Modifier.fillMaxSize(),
                                painter = painterResource(id = R.drawable.ic_baseline_check_24),
                                contentDescription = "date",
                                tint = Picton400
                            )
                        }
                    }
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                                text = "Toyota Fortuner",
                                style = MaterialTheme.typography.body1,
                                fontWeight = FontWeight.Bold,
                                color = Picton500
                        )
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                            Icon(
                                    modifier = Modifier.size(15.dp),
                                    painter = painterResource(id = R.drawable.ic_date),
                                    contentDescription = "date",
                                    tint = Picton400
                            )
                            Text(
                                text = "29/08/2022 - 30/08/2022",
                                style = MaterialTheme.typography.subtitle2,
                                color = Picton400
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                            Icon(
                                modifier = Modifier.size(15.dp),
                                painter = painterResource(id = R.drawable.ic_rupiah),
                                contentDescription = "harga",
                                tint = Picton400
                            )
                            Text(
                                text = "1.000.000",
                                style = MaterialTheme.typography.subtitle2,
                                color = Picton400
                            )
                        }
                    }
                }
            }

        }
    }
}

@Preview (showBackground = true)
@Composable
fun barPrev() {
    Column(modifier = Modifier.fillMaxSize()){
        Statbar()
    }
}