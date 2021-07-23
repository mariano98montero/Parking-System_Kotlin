package com.parking_system_kotlin.mvp.view

import android.app.Activity
import android.widget.Toast
import com.parking_system_kotlin.fragments.SpacesSettingDialogFragment
import com.parking_system_kotlin.listeners.ListenerSetParkingDialogFragment
import com.parking_system_kotlin.mvp.contracts.ParkingContract
import com.parking_system_kotlin.mvp.view.base.ActivityView
import com.parking_system_kotlin.utils.Constants
import com.parkingsystemkotlin.R

class ParkingView(activity: Activity) : ActivityView(activity), ParkingContract.MainActivityView {
    override fun showDialogFragment(listenerSetParkingDialogFragment: ListenerSetParkingDialogFragment) {
        fragmentManager?.let {
            val dialogFragment: SpacesSettingDialogFragment = SpacesSettingDialogFragment.newInstance(listenerSetParkingDialogFragment)
            dialogFragment.show(it, Constants.DIALOG_SPACES_SPACES_SETTING)
        }
    }

    override fun showParkingLotsAvailable(parkingLots: String) {
        context?.let {
            Toast.makeText(it, it?.getString(R.string.main_activity_toast_set_parking_lots, parkingLots), Toast.LENGTH_LONG)
                .show()
        }
    }
}
