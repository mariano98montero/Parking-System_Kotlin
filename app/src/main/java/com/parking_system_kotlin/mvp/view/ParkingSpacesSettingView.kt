package com.parking_system_kotlin.mvp.view

import android.widget.Toast
import com.parking_system_kotlin.fragments.SpacesSettingDialogFragment
import com.parking_system_kotlin.listeners.ListenerSetParkingDialogFragment
import com.parking_system_kotlin.mvp.contracts.ParkingSpacesSettingContract
import com.parking_system_kotlin.mvp.view.base.FragmentView
import com.parkingsystemkotlin.R

class ParkingSpacesSettingView(fragment: SpacesSettingDialogFragment) : FragmentView(fragment),
    ParkingSpacesSettingContract.ParkingSpacesSettingDialogFragmentView {

    override fun showParkingLotsAvailable(parkingLots: String, listenerSetParkingDialogFragment: ListenerSetParkingDialogFragment) {
        val fragment: SpacesSettingDialogFragment = fragment as SpacesSettingDialogFragment
        fragment.dismiss()
        listenerSetParkingDialogFragment.listenFreeSpaces(parkingLots)
    }

    override fun showInvalidValue() {
        context?.let {
            Toast.makeText(it, it?.getString(R.string.dialog_fragment_toast_invalid_value), Toast.LENGTH_LONG).show()
        }
    }
}
