package com.example.rentall.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rentall.ui.theme.Picton100
import com.example.rentall.ui.theme.Picton300
import com.example.rentall.ui.theme.Picton400

@Composable
fun DefaultTextField(value: String,
                     onValueChange: (String) -> Unit,
                     outline: Boolean = false,
                     placeholder: String = "Placeholder",
                     modifier: Modifier = Modifier,
                     maxLines: Int = 1
){
    if(outline){
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(placeholder, color = Picton400, style = MaterialTheme.typography.h6) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Picton400,
                focusedIndicatorColor = Picton400,
                unfocusedIndicatorColor = Picton400,
            ),
            shape= RoundedCornerShape(8.dp),
        )
    }
    else{
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(placeholder, color = Picton400, style = MaterialTheme.typography.h6) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Picton100,
                textColor = Picton400,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = modifier,
            shape= RoundedCornerShape(8.dp),
            maxLines = maxLines
        )
    }
}

@Preview(showBackground = true)
@Composable
fun defaultButtonPreview(){
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()){
        DefaultTextField(value = text, onValueChange = {text = it} )
        DefaultTextField(value = text, onValueChange = {text = it}, outline = true )
        TextField(value = text, onValueChange = {text = it})
    }
}
