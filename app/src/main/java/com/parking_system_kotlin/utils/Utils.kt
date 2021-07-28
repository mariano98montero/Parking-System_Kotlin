package com.parking_system_kotlin.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

fun Calendar.getStringFromDate(): String {
    var inActiveDate: String = Constants.EMPTY_STRING
    try {
        inActiveDate = SimpleDateFormat(Constants.DATE_FORMAT).format(this.time)
    } catch (exception: Exception) {
        exception.printStackTrace()
    }
    return inActiveDate
}

fun String.getCalendarFromString(): Calendar? {
    if (this.isNotEmpty()) {
        val calendar = Calendar.getInstance()
        val date: Date
        try {
            val date = SimpleDateFormat(Constants.DATE_FORMAT).parse(this)
            calendar.time = date
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return calendar
    }
    return null
}
