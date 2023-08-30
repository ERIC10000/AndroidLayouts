package com.example.androidlayouts

import android.app.DatePickerDialog
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.json.JSONArray
import org.json.JSONObject
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

        // find the register button and Send data to the api
        val registerBtn : Button = findViewById(R.id.buttonRegister1)
        registerBtn.setOnClickListener {
            // get data from the preference
            val prefs: SharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)
            val username = prefs.getString("username", "")
            val phone = prefs.getString("phone", "")
            val email = prefs.getString("email", "")
            val password = prefs.getString("password", "")
            val dob = editDOB.text.toString()

            // Async LoopJ Library: Send data over the internet to the hosted api
            val helper = ApiHelper(applicationContext)

            // lets get api, body,
            val api = "http://erickapi.pythonanywhere.com/register"
            val body = JSONObject()
            body.put("username", username)
            body.put("phone", phone)
            body.put("email", email)
            body.put("password", password)
            body.put("dob", dob)

            helper.post(api, body, object : ApiHelper.CallBack{
                override fun onSuccess(result: JSONArray?) {
                    TODO("Not yet implemented")
                }

                override fun onSuccess(result: JSONObject?) {
                    Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(result: String?) {
                    Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
                }
            })

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