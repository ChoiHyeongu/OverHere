package com.untitled1.how_about_here

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_curation.*

class CurationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curation)

        val intent = getIntent()
        val title = intent.getStringExtra("Title")
        val img = intent.getIntExtra("Img", 0)

        curation_name.text = title.toString()
        curation_img.setImageResource(img)
    }
}
