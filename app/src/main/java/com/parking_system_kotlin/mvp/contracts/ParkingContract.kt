package com.parking_system_kotlin.mvp.contracts

import com.parking_system_kotlin.listeners.ListenerSetParkingDialogFragment

interface ParkingContract {

    interface MainActivityModel {
        fun setParkingLots(parkingLots: String)
        fun getParkingLots(): String
    }

    interface MainActivityPresenter {
        fun onSetParkingButtonPressed(listenerSetParkingDialogFragment: ListenerSetParkingDialogFragment)
        fun setParkingSpacesAvailable(spacesAvailable: String)
    }

    interface MainActivityView {
        fun showDialogFragment(listenerSetParkingDialogFragment: ListenerSetParkingDialogFragment)
        fun showParkingLotsAvailable(parkingLots: String)
    }
}
