package com.untitled1.how_about_here

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class CurationRecyclerViewAdapter(list: ArrayList<Curation>, _opt: Int): RecyclerView.Adapter<ViewHolder>(){

    private val curationList = list
    private var opt = _opt
    private lateinit var context: Context
    private lateinit var card: View

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): ViewHolder {

        context = parent.context
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
        parent.layout.setOnClickListener {
            val intent = Intent(context, CurationActivity::class.java)

            Log.d("PutExtra", curationList[pos].img.toString())
            intent.putExtra("Title", curationList[pos].text)
            intent.putExtra("Img", curationList[pos].img)

            context.startActivity(intent)
        }
    }
}

class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
    val layout = v.findViewById<LinearLayout>(R.id.curation_layout)
    val imageView = v.findViewById<ImageView>(R.id.horizontal_curationImage)
    val textView  = v.findViewById<TextView>(R.id.horizontal_curationText)
    val timeView = v.findViewById<TextView>(R.id.horizontal_curationTime)
}