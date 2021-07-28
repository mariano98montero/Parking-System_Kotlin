package com.parking_system_kotlin.mvp.presenter

import com.parking_system_kotlin.listeners.ListenerSetParkingDialogFragment
import com.parking_system_kotlin.mvp.contracts.ParkingContract

class ParkingPresenter(private val model: ParkingContract.MainActivityModel, private val view: ParkingContract.MainActivityView) :
    ParkingContract.MainActivityPresenter {

    override fun onSetParkingButtonPressed(listenerSetParkingDialogFragment: ListenerSetParkingDialogFragment) {
        view.showDialogFragment(listenerSetParkingDialogFragment)
    }

    override fun setParkingSpacesAvailable(spacesAvailable: String) {
        model.setParkingLots(spacesAvailable)
        view.showParkingLotsAvailable(model.getParkingLots())
    }

    override fun onReservationButtonPressed() {
        view.showReservationActivity()
    }
}
