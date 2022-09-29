package com.example.rentall.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.example.rentall.R
import com.example.rentall.component.ButtonSize
import com.example.rentall.component.ButtonType
import com.example.rentall.component.button.Padding


@Composable
fun IconButton(buttonType: ButtonType = ButtonType.PRIMARY,
               size: ButtonSize = ButtonSize.MEDIUM,
               onClick: () -> Unit = {},
               iconId: Int
){
    var border: Dp
    var shape: Dp
    var buttonSize: Dp

    if(size.equals(ButtonSize.LARGE)){
        border = 4.dp
        shape = 16.dp
        buttonSize = 74.dp
    }
    else if(size.equals(ButtonSize.MEDIUM)){
        border = 4.dp
        shape = 14.dp
        buttonSize = 54.dp
    }
    else{
        border = 4.dp
        shape = 7.dp
        buttonSize = 40.dp
    }

    val colors =
        if(buttonType == ButtonType.PRIMARY)
            ButtonDefaults.buttonColors()
        else if(buttonType == ButtonType.OUTLINE)
            ButtonDefaults.outlinedButtonColors()
        else
            ButtonDefaults.textButtonColors()

    Button(onClick = onClick,
        colors = colors,
        border = BorderStroke(border, color = MaterialTheme.colors.primary),
        shape = RoundedCornerShape(shape),
        modifier = Modifier
            .width(buttonSize)
            .height(buttonSize)
    ) {
        Icon(
            painter = painterResource(id = iconId),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
            ,
            contentDescription = "drawable icons",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IconButtonPreview(){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick = { /*TODO*/ }) {
            Text(text = "insert text")
        }
        IconButton( buttonType = ButtonType.PRIMARY, size=ButtonSize.SMALL, iconId = R.drawable.ic_baseline_chevron_right_24)
        IconButton( buttonType = ButtonType.PRIMARY, size=ButtonSize.MEDIUM, iconId = R.drawable.ic_baseline_chevron_right_24)
        IconButton( buttonType = ButtonType.OUTLINE, size=ButtonSize.LARGE, iconId = R.drawable.ic_baseline_chevron_right_24)
    }
}
