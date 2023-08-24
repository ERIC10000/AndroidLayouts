package com.example.androidlayouts

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SingleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        // getting data from the shared preference
        val prefs: SharedPreferences = getSharedPreferences("storage", Context.MODE_PRIVATE)
        val name = prefs.getString("room_name", "")
        val desc = prefs.getString("item_desc", "")

        // find the two views and bind the data
        val nameTextView : TextView = findViewById(R.id.roomName)
        val descTextView : TextView = findViewById(R.id.roomDesc)

        // binding data to the view
        nameTextView.text = name
        descTextView.text = desc
    }
}