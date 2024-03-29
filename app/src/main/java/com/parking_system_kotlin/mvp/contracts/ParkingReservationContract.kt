package com.parking_system_kotlin.mvp.contracts

import com.parking_system_kotlin.listeners.ListenerDateTime
import java.util.Calendar


interface ParkingReservationContract {

    interface ParkingReservationPresenter {
        fun showDatePicker(listenerDateTime: ListenerDateTime, dateSelector: Boolean)
        fun setEntryDate(entryDate: Calendar)
        fun setExitDate(exitDate: Calendar)
        fun saveReservation()
    }

    interface ParkingReservationView {
        fun showDatePicker(listenerDateTime: ListenerDateTime, dateSelector: Boolean)
        fun showEntryDateSelected(date: String)
        fun showExitDateSelected(date: String)
        fun closeScreen()
    }
}
