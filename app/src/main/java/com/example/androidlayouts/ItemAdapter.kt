package com.example.androidlayouts

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(private val itemList: List<Item>, val context: Context) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        val descriptionTextView: TextView = itemView.findViewById(R.id.textViewDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.imageView.setImageResource(currentItem.imageResId)
        holder.titleTextView.text = currentItem.title
        holder.descriptionTextView.text = currentItem.description

        holder.itemView.setOnClickListener {

            //create SharedPreference and Save the data of the View Holder
            // On SingleActivity, we get data the saved data from SPreferences

            val prefs: SharedPreferences = context.getSharedPreferences("storage", Context.MODE_PRIVATE)
            val editor = prefs.edit()

            editor.putInt("item_image", currentItem.imageResId)
            editor.putString("room_name", currentItem.title)
            editor.putString("item_desc", currentItem.description)
            editor.apply()

            // Intent to the SingleActivity
            val intent = Intent(context, SingleActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)


        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}