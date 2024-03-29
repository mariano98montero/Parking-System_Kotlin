package com.parking_system_kotlin.mvp.presenter

import com.parking_system_kotlin.listeners.ListenerDateTime
import com.parking_system_kotlin.mvp.contracts.ParkingReservationContract
import com.parking_system_kotlin.utils.getStringFromDate
import java.util.Calendar

class ParkingReservationPresenter(private val view: ParkingReservationContract.ParkingReservationView) :
    ParkingReservationContract.ParkingReservationPresenter {

    override fun showDatePicker(listenerDateTime: ListenerDateTime, dateSelector: Boolean) {
        view.showDatePicker(listenerDateTime, dateSelector)
    }

    override fun setEntryDate(entryDate: Calendar) {
        view.showEntryDateSelected(entryDate.getStringFromDate())
    }

    override fun setExitDate(exitDate: Calendar) {
        view.showExitDateSelected(exitDate.getStringFromDate())
    }

    override fun saveReservation() {
        view.closeScreen()
    }
}
