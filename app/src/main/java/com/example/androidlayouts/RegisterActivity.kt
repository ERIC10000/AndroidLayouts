package com.example.androidlayouts

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val username: EditText = findViewById(R.id.username)
        val phone : EditText = findViewById(R.id.phone)
        val email : EditText = findViewById(R.id.email)
        val password : EditText = findViewById(R.id.password)

        // find tvRegister1, give an Intent(message) to LoginActivity
        val tvRegister1 : TextView = findViewById(R.id.tvRegister1)
        tvRegister1.setOnClickListener {
            val intentLogin = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intentLogin)
        }

        val buttonRegister1 : Button = findViewById(R.id.buttonRegister1)
        buttonRegister1.setOnClickListener {
            // save username, phone, email, password to Preferences and Intent to the other activity
            val prefs: SharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)
            val editor = prefs.edit()
            editor.putString("username", username.text.toString())
            editor.putString("phone", phone.text.toString())
            editor.putString("email", email.text.toString())
            editor.putString("password", password.text.toString())
            editor.apply()


            val intentLogin = Intent(applicationContext, RegisterActivity2::class.java)
            startActivity(intentLogin)

        }


    }
}