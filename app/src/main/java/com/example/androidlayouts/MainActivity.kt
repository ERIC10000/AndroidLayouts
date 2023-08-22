package com.example.androidlayouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // intent to HomeActivity
        val cardHome : CardView = findViewById(R.id.cardHome)
        cardHome.setOnClickListener {
            val intentHome = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intentHome)
        }

        // intent to ChatActivity
        val cardChart : CardView = findViewById(R.id.cardChart)
        cardChart.setOnClickListener {
            val intentChart = Intent(applicationContext, ChatActivity::class.java)
            startActivity(intentChart)
        }

    }
}

// AndroidManifest.xml: This file used to provide description about the application
// 1. App Icon
// 2. Theme
// 3. Activities(Screens)
// 4. Give Permissions

// Java Folder: It contains 3 packages
// 1. Use to create Activities, here is where all the Kotlin codes are created

// res(Resources Folder): It contains components that your app requires e,g images, icon...
// 1. drawable: This folder contains all the images and icons
// 2. layouts: Contains XML files to build User Interface(UI) of every activity