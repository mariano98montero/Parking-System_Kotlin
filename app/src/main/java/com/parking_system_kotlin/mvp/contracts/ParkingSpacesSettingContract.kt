package com.parking_system_kotlin.mvp.contracts

import com.parking_system_kotlin.listeners.ListenerSetParkingDialogFragment

interface ParkingSpacesSettingContract {

    interface ParkingSpacesSettingDialogFragmentPresenter {
        fun onButtonDialogFragmentSpacesSettingConfirmationPressed(
            freeSpaces: String,
            listenerSetParkingDialogFragment: ListenerSetParkingDialogFragment
        )
    }

    interface ParkingSpacesSettingDialogFragmentView {
        fun showParkingLotsAvailable(parkingLots: String, listenerSetParkingDialogFragment: ListenerSetParkingDialogFragment)
        fun showInvalidValue()
    }
}
