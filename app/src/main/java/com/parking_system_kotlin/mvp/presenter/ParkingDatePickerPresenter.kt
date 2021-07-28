package com.parking_system_kotlin.mvp.presenter

import com.parking_system_kotlin.listeners.ListenerDateTime
import com.parking_system_kotlin.mvp.contracts.ParkingDatePickerContract

class ParkingDatePickerPresenter(private var view: ParkingDatePickerContract.ParkingDatePickerView, private val dateSelector: Boolean?) :
    ParkingDatePickerContract.ParkingDatePickerPresenter {

    override fun onButtonDialogFragmentDatePickerConfirmationPressed(listenerDateTime: ListenerDateTime) {
        if (dateSelector == true) {
            view.showEntryReservationDate(listenerDateTime)
        } else {
            view.showExitReservationDate(listenerDateTime)
        }
    }

    override fun closeDateDialog() {
        view.closeDateDialog()
    }
}
