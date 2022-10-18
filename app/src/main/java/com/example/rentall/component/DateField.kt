package com.example.rentall.component

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.rentall.R
import com.example.rentall.component.textfield.DefaultTextField
import java.util.*

@Composable
fun DateField(
    modifier: Modifier = Modifier,
    mDate: String,
    onValueChange: (String) -> Unit,
) {

    DefaultTextField(
        modifier = modifier,
        placeholder = "Date",
        value = mDate,
        onValueChange = onValueChange,
        trailingIcon = R.drawable.ic_date,
        readOnly = true
    )
}

@Preview(showBackground = true)
@Composable
fun DataFieldPrev() {
    var time by remember { mutableStateOf("")}
    Column(Modifier.fillMaxSize()) {
        DateField(mDate = time){
            time = it
        }
    }
}