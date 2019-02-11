package com.untitled1.how_about_here

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class CurationRecyclerViewAdapter(list: ArrayList<Curation>, _opt: Int): RecyclerView.Adapter<ViewHolder>(){

    private val curationList = list
    private var opt = _opt
    private lateinit var card: View

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        when (opt){
            1 -> card = layoutInflater.inflate(R.layout.horizontal_curation, parent, false)
            2 -> card = layoutInflater.inflate(R.layout.vertical_curation, parent, false)
        }
        return ViewHolder(card)
    }

    override fun getItemCount(): Int = curationList.size

    override fun onBindViewHolder(parent: ViewHolder, pos: Int) {
        parent.imageView.setImageResource(curationList[pos].img)
        parent.textView.text = curationList[pos].text
        parent.timeView.text = curationList[pos].time
    }
}

class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
    val imageView = v.findViewById<ImageView>(R.id.horizontal_curationImage)
    val textView  = v.findViewById<TextView>(R.id.horizontal_curationText)
    val timeView = v.findViewById<TextView>(R.id.horizontal_curationTime)
}