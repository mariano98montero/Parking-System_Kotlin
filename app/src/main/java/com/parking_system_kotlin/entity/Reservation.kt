package com.parking_system_kotlin.entity

import com.parking_system_kotlin.utils.getCalendarFromString

data class Reservation(private val entryDateIn: String, private val exitDateIn: String, private val keyCodeIn: String) {
    private val entryDate = entryDateIn.getCalendarFromString()
    private val exitDate = exitDateIn.getCalendarFromString()
    private val keyCode = keyCodeIn
}
