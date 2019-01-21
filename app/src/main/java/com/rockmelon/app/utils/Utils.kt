package com.rockmelon.app.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.rockmelon.app.MovieApp

object Utils {

    const val KEY_ITEM = "item"

    fun pxFromDp(context: Context?, dp: Float): Float {
        return dp * context?.resources?.displayMetrics?.density!!
    }

    fun loadImage(view:ImageView, url:String?){
        Glide.with(MovieApp.get()).load(url).into(view);
    }
}