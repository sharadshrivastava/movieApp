package com.rockmelon.app.utils

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object Utils {


    fun getDaysDifference(prevDateStr: String?):Long {
        var prevDate = getDate(prevDateStr)
        var days = TimeUnit.MILLISECONDS.toDays(Math.abs(System.currentTimeMillis() - prevDate.time));
        return days
    }

    fun dpFromPx(context: Context, px: Float): Float {
        return px / context.resources.displayMetrics.density
    }

    fun pxFromDp(context: Context?, dp: Float): Float {
        return dp * context?.resources?.displayMetrics?.density!!
    }

    fun getDate(dateStr:String?):Date{
        val serverDateFormat = "dd/MM/yyyy"
        return SimpleDateFormat(serverDateFormat).parse(dateStr)
    }
}