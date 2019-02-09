package com.example.motivation.overhere

import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class CurationRecyclerviewAdapter(list: ArrayList<Curation>, _opt: Int) : RecyclerView.Adapter<CustomViewHolder>() {

    var curationList: ArrayList<Curation> = list
    var opt = _opt
    lateinit var cellForRow: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        if (opt == 0) {
            cellForRow = layoutInflater.inflate(R.layout.item_cardview, parent, false)
        } else {
            cellForRow = layoutInflater.inflate(R.layout.item_cardview2,parent, false)
        }

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


