package com.example.rentall.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rentall.R
import com.example.rentall.ui.theme.*

@Composable
fun DefaultTextField(value: String,
                     onValueChange: (String) -> Unit,
                     outline: Boolean = false,
                     placeholder: String = "Placeholder",
                     modifier: Modifier = Modifier,
                     maxLines: Int = 1,
                     password: Boolean = false
){
    var passwordVisible by remember { mutableStateOf(false) }
    var visualTransformation =
        if(!password)
            VisualTransformation.None
        else{
            if(passwordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation()
        }
        val image =
            if (passwordVisible)
                R.drawable.ic_eye_closed
            else
                R.drawable.ic_eye_open

        val description = if (passwordVisible) "Hide password" else "Show password"

    if(outline){
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(placeholder, color = Picton400, style = MaterialTheme.typography.h4) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Picton400,
                focusedIndicatorColor = Picton400,
                unfocusedIndicatorColor = Picton400,
            ),
            shape= RoundedCornerShape(8.dp),
            visualTransformation = visualTransformation,
            trailingIcon ={
                if(password) {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(painter = painterResource(id = image), description)
                    }
                }
            }
        )
    }
    else{
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(placeholder, color = Picton400, style = MaterialTheme.typography.h5) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Picton100,
                textColor = Picton400,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = modifier,
            shape= RoundedCornerShape(8.dp),
            maxLines = maxLines,
            visualTransformation = visualTransformation,
            trailingIcon = {
                if(password){
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(painter = painterResource(id = image), description, tint = Picton500)
                    }
                }
            }

        )
    }
}

@Preview(showBackground = true)
@Composable
fun defaultButtonPreview(){
    var text by remember { mutableStateOf("") }

    RentAllTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = { text = it },
                placeholder = "Nama Lengkap"
            )
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = { text = it },
                placeholder = "Nama Lengkap"
            )
            DefaultTextField(value = text, onValueChange = { text = it }, outline = true)
            TextField(value = text, onValueChange = { text = it })
        }
    }
}
