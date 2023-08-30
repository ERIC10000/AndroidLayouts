package com.example.androidlayouts

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class ItemAdapter( val context: Context) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var itemList: List<Item> = listOf()

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textViewRoomName: TextView = itemView.findViewById(R.id.textViewRoomName)
        val textViewRoomCost: TextView = itemView.findViewById(R.id.textViewRoomCost)
        val textViewRoomDesc: TextView = itemView.findViewById(R.id.textViewRoomDesc)
        val textViewRoomAvailability : TextView = itemView.findViewById(R.id.textViewRoomAvailability)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.textViewRoomName.text = currentItem.room_name
        holder.textViewRoomDesc.text = currentItem.room_desc
        holder.textViewRoomCost.text = currentItem.room_cost.toString()
        holder.textViewRoomAvailability.text = currentItem.availability

//        Glide.with(context)
//            .load(currentItem.image_url)
//            .apply(RequestOptions().centerCrop().placeholder(R.drawable.conference1)).into(holder.imageView)

        holder.itemView.setOnClickListener {

            //create SharedPreference and Save the data of the View Holder
            // On SingleActivity, we get data the saved data from SPreferences

//            val prefs: SharedPreferences = context.getSharedPreferences("storage", Context.MODE_PRIVATE)
//            val editor = prefs.edit()
//
//            editor.putInt("item_image", currentItem.imageResId)
//            editor.putString("room_name", currentItem.title)
//            editor.putString("item_desc", currentItem.description)
//            editor.apply()
//
//            // Intent to the SingleActivity
//
//            val intent = Intent(context, SingleActivity::class.java)
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setRoomItems(itemList: List<Item>){
        this.itemList = itemList
        notifyDataSetChanged()
    }

}