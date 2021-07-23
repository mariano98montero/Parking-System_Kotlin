package com.parking_system_kotlin.listeners

import java.io.Serializable

interface ListenerSetParkingDialogFragment : Serializable {
    fun listenFreeSpaces(freeSpaces: String)
}
