package com.example.ujiantengahsemester

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CategoryItemAdapter(private val itemList:ArrayList<Category>):RecyclerView.Adapter<CategoryItemAdapter.ViewHolder>() {
    class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        val image:ImageView = itemview.findViewById(R.id.iv_category)
        val tvName:TextView = itemview.findViewById(R.id.tv_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (image, title) = itemList[position]
        Glide.with(holder.itemView.context)
            .load(image)
            .into(holder.image)
        holder.tvName.text = title
    }


}