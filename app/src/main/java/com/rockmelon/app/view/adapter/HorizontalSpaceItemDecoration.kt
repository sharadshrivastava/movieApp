package com.rockmelon.app.view.adapter

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

//This class is required to remove divider from last row of recycler view.
class HorizontalSpaceItemDecoration(val spaceHeight: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.getChildAdapterPosition(view) != parent.adapter!!.itemCount - 1) {
            outRect.right = spaceHeight
        }
    }
}