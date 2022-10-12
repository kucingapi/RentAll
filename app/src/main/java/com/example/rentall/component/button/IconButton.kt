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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.example.rentall.R
import com.example.rentall.component.ButtonSize
import com.example.rentall.component.ButtonType


@Composable
fun IconButtonDefault(buttonType: ButtonType = ButtonType.PRIMARY,
                      size: ButtonSize = ButtonSize.MEDIUM,
                      onClick: () -> Unit = {},
                      iconId: Int,
                      rounded: Int = 30,
                      buttonColor : Color? = null,
                      modifier: Modifier = Modifier,
                      contentPadding: Dp = 0.dp
){
    var borderStroke: BorderStroke?
    var border: Dp
    var buttonSize: Dp

    if(size.equals(ButtonSize.LARGE)){
        border = 4.dp
        buttonSize = 74.dp
    }
    else if(size.equals(ButtonSize.MEDIUM)){
        border = 4.dp
        buttonSize = 54.dp
    }
    else{
        border = 4.dp
        buttonSize = 40.dp
    }

    if(buttonType.equals(ButtonType.OUTLINE)){
        borderStroke = BorderStroke(border, color = MaterialTheme.colors.primary)
    }
    else{
        borderStroke = null
    }
    val colors =
        when (buttonType) {
            ButtonType.PRIMARY -> ButtonDefaults.buttonColors(backgroundColor =
            buttonColor ?: MaterialTheme.colors.primary
            )
            ButtonType.OUTLINE -> ButtonDefaults.outlinedButtonColors(backgroundColor =
            buttonColor ?: Color.Transparent
            )
            else -> ButtonDefaults.textButtonColors(backgroundColor =
            buttonColor ?: Color.Transparent
            )
        }

    Button(onClick = onClick,
        colors = colors,
        border = borderStroke,
        shape = RoundedCornerShape(rounded),
        modifier = modifier
            .width(buttonSize)
            .height(buttonSize),
        contentPadding = PaddingValues(contentPadding)
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
        IconButtonDefault( buttonType = ButtonType.PRIMARY, size=ButtonSize.SMALL, iconId = R.drawable.ic_baseline_chevron_right_24)
        IconButtonDefault( buttonType = ButtonType.PRIMARY, size=ButtonSize.MEDIUM, iconId = R.drawable.ic_baseline_chevron_right_24)
        IconButtonDefault( buttonType = ButtonType.OUTLINE, size=ButtonSize.LARGE, iconId = R.drawable.ic_baseline_chevron_right_24)
    }
}
