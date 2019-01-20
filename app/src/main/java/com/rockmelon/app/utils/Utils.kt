package com.rockmelon.app.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.rockmelon.app.MovieApp
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object Utils {

    const val KEY_ITEM = "item"

    fun pxFromDp(context: Context?, dp: Float): Float {
        return dp * context?.resources?.displayMetrics?.density!!
    }

    fun getDate(dateStr:String?):Date{
        val serverDateFormat = "dd/MM/yyyy"
        return SimpleDateFormat(serverDateFormat).parse(dateStr)
    }

    fun loadImage(view:ImageView, url:String?){
        Glide.with(MovieApp.get()).load(url).into(view);
    }
}