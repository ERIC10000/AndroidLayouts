package com.example.androidlayouts

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.Calendar

class RegisterActivity2 : AppCompatActivity() {
    private lateinit var btnDOB : Button
    private lateinit var editDOB: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)

        // find btnDOB and editDOB
         btnDOB  = findViewById(R.id.btnDOB)
        editDOB = findViewById(R.id.editDOB)

        // give btnDOB an onClickListener{}
        btnDOB.setOnClickListener {
            // call the DatePicker function
            showDatePickerDilog()
        }

    } // end onCreate() -> main()

    // 1-2pm
    // create datePicker()
    // 2023-8-22
    private fun showDatePickerDilog(){
        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDay"
                editDOB.setText(selectedDate)
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

}