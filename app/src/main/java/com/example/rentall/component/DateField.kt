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
    val mContext = LocalContext.current

    // Declaring integer values
    // for year, month and day
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    // Declaring a string value to
    // store date in string format

    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            onValueChange("$mDayOfMonth/${mMonth+1}/$mYear")
        }, mYear, mMonth, mDay
    )

    DefaultTextField(
        placeholder = "Date",
        modifier = modifier.clickable { mDatePickerDialog.show() },
        value = mDate,
        onValueChange = {},
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