package com.parking_system_kotlin.mvp.presenter

import com.parking_system_kotlin.listeners.ListenerSetParkingDialogFragment
import com.parking_system_kotlin.mvp.contracts.ParkingSpacesSettingContract

class ParkingSpacesSettingPresenter(view: ParkingSpacesSettingContract.ParkingSpacesSettingDialogFragmentView) :
    ParkingSpacesSettingContract.ParkingSpacesSettingDialogFragmentPresenter {
    private var view: ParkingSpacesSettingContract.ParkingSpacesSettingDialogFragmentView = view

    override fun onButtonDialogFragmentSpacesSettingConfirmationPressed(
        freeSpaces: String,
        listenerSetParkingDialogFragment: ListenerSetParkingDialogFragment
    ) {
        if (freeSpaces.isEmpty()) {
            view.showInvalidValue()
        } else {
            view.showParkingLotsAvailable(freeSpaces, listenerSetParkingDialogFragment)
        }
    }
}
