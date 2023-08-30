package com.example.androidlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONObject

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // binding data from the Model, through ViewModel to the View
         recyclerView = findViewById(R.id.recyclerView)
        itemAdapter = ItemAdapter(applicationContext)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        // =====call the api and pass data to the recyclerview adapter
       val helper = ApiHelper(applicationContext)
        val api = "http://erickapi.pythonanywhere.com/get_rooms"
        helper.get(api, object : ApiHelper.CallBack{
            override fun onSuccess(result: JSONArray?) {
                // gson library: To convert JSONArray response(result) to List<Item>
                val gson = GsonBuilder().create()
                val list = gson.fromJson(result.toString(), Array<Item>::class.java).toList()
                itemAdapter.setRoomItems(list)
            }

            override fun onSuccess(result: JSONObject?) {
                TODO("Not yet implemented")
            }

            override fun onFailure(result: String?) {
                TODO("Not yet implemented")
            }
        })

       recyclerView.adapter = itemAdapter

    }

}