package com.example.rentall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rentall.component.textfield.DefaultTextField
import com.example.rentall.ui.theme.RentAllTheme
import com.example.rentall.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember { mutableStateOf("") }
            RentAllTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Greeting("Android")
                        DefaultTextField(value = text, onValueChange = { text = it })
                        DefaultTextField(value = text, onValueChange = { text = it }, outline = true)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    var text by remember { mutableStateOf("") }
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.fillMaxSize()) {
            Greeting("Android")
            DefaultTextField(value = text, onValueChange = { text = it })
            TextField(value = text, onValueChange = {text = it})
        }
    }
}