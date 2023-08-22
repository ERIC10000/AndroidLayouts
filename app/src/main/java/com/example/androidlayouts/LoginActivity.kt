package com.example.androidlayouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // codes are executed here
        // functions are called here..
        // objects are created here

        // Find Views Based on Id
        // Add Event Listener
        val buttonLogin : Button = findViewById(R.id.buttonLogin)
        buttonLogin.setOnClickListener {
            // Intent -> message in android
            // Intent to move from LoginActivity(applicationContext) to MainActivity
            val intentMain = Intent(applicationContext, MainActivity::class.java)
            startActivity(intentMain)
        }

        val tvLogin : TextView = findViewById(R.id.tvLogin)
        tvLogin.setOnClickListener {
            // Intent -> message in android
            // Intent to move from LoginActivity(applicationContext) to MainActivity
            val intentMain = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intentMain)
        }


    } // end onCreate() -> main

    // outside onCreate()
    // create functions and classes
}

// 1pm. - 2pm
// Intents
// Toast