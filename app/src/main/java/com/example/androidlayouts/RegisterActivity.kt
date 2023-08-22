package com.example.androidlayouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // find tvRegister1, give an Intent(message) to LoginActivity
        val tvRegister1 : TextView = findViewById(R.id.tvRegister1)
        tvRegister1.setOnClickListener {
            val intentLogin = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intentLogin)
        }

        val buttonRegister1 : Button = findViewById(R.id.buttonRegister1)
        buttonRegister1.setOnClickListener {
            val intentLogin = Intent(applicationContext, RegisterActivity2::class.java)
            startActivity(intentLogin)

        }


    }
}