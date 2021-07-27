package com.parking_system_kotlin.listeners

import java.io.Serializable
import java.util.Calendar

interface ListenerDateTime : Serializable {
    fun setEntryDate(entryDate: Calendar)
    fun setExitDate(exitDate: Calendar)
}
