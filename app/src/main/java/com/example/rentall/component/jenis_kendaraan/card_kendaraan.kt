package com.example.rentall.component.jenis_kendaraan

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rentall.R
import com.example.rentall.component.ButtonSize
import com.example.rentall.component.ButtonType
import com.example.rentall.component.DefaultButton
import com.example.rentall.component.button.IconButtonDefault
import com.example.rentall.ui.theme.GridMargin
import com.example.rentall.ui.theme.Picton100
import com.example.rentall.ui.theme.Picton50
import com.example.rentall.ui.theme.Picton500

@Composable
fun jenis_mobil(jenis: String, onClick: () -> Unit = {}){

        Card(modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15)){
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                ,verticalArrangement = Arrangement.SpaceBetween
            ){
                Image(modifier = Modifier
                    .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.car),
                    contentDescription = "gambar mobil",
                    contentScale = ContentScale.Fit
                )
                Column(verticalArrangement = Arrangement.spacedBy(1.dp)) {
                    Text(text = "Toyota Fortuner", style = MaterialTheme.typography.body2, fontWeight = FontWeight.Bold)
                    Text(text = "SUV", style = MaterialTheme.typography.subtitle2,fontSize = 9.sp, color = Color.Gray)
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom){
                    Text(
                        text = "Rp. 100.000/hari",
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start
                    )
                    IconButtonDefault(
                        buttonType = ButtonType.PRIMARY,
                        size = ButtonSize.SMALL,
                        iconId = R.drawable.ic_baseline_chevron_right_24,
                        onClick = {
                            onClick()
                        }
                    )

                }

            }

        }
    }



@Preview(showBackground = true)
@Composable
fun jenis_mobilprev() {
    Row(modifier = Modifier.fillMaxSize()){

        jenis_mobil(jenis = "Motor")
    }
}


