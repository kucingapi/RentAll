package com.example.rentall.component

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
import com.example.rentall.component.button.Padding


@Composable
fun DefaultButton(text: String = "",
                  buttonType: ButtonType = ButtonType.PRIMARY,
                  size: ButtonSize = ButtonSize.MEDIUM,
                  modifier: Modifier = Modifier,
                  paddingInput: Padding? = null,
                  iconRight: Int? = null,
                  iconLeft: Int? = null,
                  onClick: () -> Unit = {}
){
    lateinit var textStyle: TextStyle
    lateinit var padding: Padding
    var iconSize: Dp
    var border: Dp
    var shape: Dp

    if(size.equals(ButtonSize.LARGE)){
        textStyle = MaterialTheme.typography.h3
        padding = Padding(10.dp, 5.dp)
        border = 4.dp
        shape = 16.dp
        iconSize = 54.dp
    }
    else if(size.equals(ButtonSize.MEDIUM)){
        textStyle = MaterialTheme.typography.h4
        padding = Padding(5.dp, 2.dp)
        border = 4.dp
        shape = 14.dp
        iconSize = 32.dp
    }
    else{
        textStyle = MaterialTheme.typography.h6
        padding = Padding(0.dp, 0.dp)
        border = 4.dp
        shape = 7.dp
        iconSize = 16.dp
    }
    if(paddingInput != null){
        padding = paddingInput
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
    ) {
        Row(modifier = modifier.padding(horizontal = padding.horizontal, vertical =  padding.vertical),
            verticalAlignment = Alignment.CenterVertically) {
            if(iconLeft != null) {
                Icon(
                    painter = painterResource(id = iconLeft),
                    modifier = Modifier
                        .size(iconSize),
                    contentDescription = "drawable icons",
                )
            }
            Text(
                modifier = modifier.padding(
                    horizontal = padding.horizontal,
                    vertical = padding.vertical
                ),
                text = text, style = textStyle,
                fontWeight = FontWeight.Medium
            )
            if(iconRight != null) {
                Icon(
                    painter = painterResource(id = iconRight),
                    modifier = Modifier
                        .size(iconSize),
                    contentDescription = "drawable icons",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun defaultButtonPreview(){
    Column(modifier = Modifier.fillMaxSize()){
        Button(onClick = { /*TODO*/ }) {
            Text(text = "insert text")
        }
        DefaultButton(text = "insert text", buttonType = ButtonType.PRIMARY, size=ButtonSize.SMALL)
        DefaultButton(text = "insert text", buttonType = ButtonType.OUTLINE, size=ButtonSize.MEDIUM)
        DefaultButton(text = "insert text", buttonType = ButtonType.OUTLINE, size=ButtonSize.LARGE)
    }
}