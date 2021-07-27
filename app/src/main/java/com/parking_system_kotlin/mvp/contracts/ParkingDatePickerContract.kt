package com.parking_system_kotlin.mvp.contracts

import com.parking_system_kotlin.listeners.ListenerDateTime

interface ParkingDatePickerContract {

    interface ParkingDatePickerPresenter {
        fun onButtonDialogFragmentDatePickerConfirmationPressed(listenerDateTime: ListenerDateTime)
        fun closeDateDialog()
    }

    interface ParkingDatePickerView {
        fun showEntryReservationDate(listenerDateTime: ListenerDateTime)
        fun showExitReservationDate(listenerDateTime: ListenerDateTime)
        fun closeDateDialog()
    }
}
