package com.parking_system_kotlin.entity

import com.parking_system_kotlin.utils.getCalendarFromString
import java.util.Calendar

class Reservation(entryDate: String, exitDate: String, keyCode: String) {
    private val entryDate: Calendar = entryDate.getCalendarFromString()
    private val exitDate: Calendar = exitDate.getCalendarFromString()
    private val keyCode: String = keyCode
}
