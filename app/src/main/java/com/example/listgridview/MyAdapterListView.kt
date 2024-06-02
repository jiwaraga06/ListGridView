package com.example.listgridview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapterListView(private val itemList: kotlin.collections.List<MyItemListView>) : RecyclerView.Adapter<MyAdapterListView.ViewHolder>() {
    class ViewHolder (@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView : ImageView = itemView.findViewById(R.id.titleImg)
        val title : TextView = itemView.findViewById(R.id.Title)
        val subTitle : TextView = itemView.findViewById(R.id.SubTitle)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyAdapterListView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapterListView.ViewHolder, position: Int) {
        val item = itemList[position]
        holder.title.text = item.title
        holder.subTitle.text = item.subTitle
        Glide.with(holder.imgView.context).load(item.titleImg).into(holder.imgView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}