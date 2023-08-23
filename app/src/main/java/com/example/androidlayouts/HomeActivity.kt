package com.example.androidlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // binding data from the Model, through ViewModel to the View
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val itemAdapter: ItemAdapter = ItemAdapter(generateData())
        recyclerView.adapter = itemAdapter

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

    }

    // create generateData()
    private fun generateData(): List<Item>{
        return listOf(
            Item(R.drawable.conference1, "Spacius Rooms", "Affordable"),
            Item(R.drawable.conference1, "Spacius Rooms", "Affordable"),
            Item(R.drawable.conference1, "Spacius Rooms", "Affordable"),
            Item(R.drawable.conference1, "Spacius Rooms", "Affordable"),
            Item(R.drawable.conference1, "Spacius Rooms", "Affordable"),
            Item(R.drawable.conference1, "Spacius Rooms", "Affordable"),
        )
    }
}