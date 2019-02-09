package com.example.motivation.overhere

import android.content.Context
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class CurationRecyclerviewAdapter(list: ArrayList<Curation>) : RecyclerView.Adapter<CustomViewHolder>() {

    var curationList: ArrayList<Curation> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_cardview, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int = curationList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.imageView.setImageResource(curationList[position].img)
        holder.titleTextView.text = curationList[position].text
        holder.timeTextView.text = curationList[position].time
    }
}

class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    val imageView = v.findViewById(R.id.cardview_img) as ImageView
    val titleTextView = v.findViewById(R.id.cardview_text) as TextView
    val timeTextView = v.findViewById(R.id.cardview_time) as TextView
}


