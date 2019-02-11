package com.example.motivation.overhere

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class RecyclerViewDecoration(private val divHeight: Int, _opt: Int) : RecyclerView.ItemDecoration() {

    val opt = _opt

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        when (opt) {
            1, 2 -> outRect.right = divHeight
            3 -> outRect.bottom = divHeight
        }
    }
} 