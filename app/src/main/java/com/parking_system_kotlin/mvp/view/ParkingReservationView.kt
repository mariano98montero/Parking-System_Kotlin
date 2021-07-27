package com.parking_system_kotlin.mvp.view

import android.app.Activity
import com.parking_system_kotlin.fragments.DateReservationDialogFragment
import com.parking_system_kotlin.listeners.ListenerDateTime
import com.parking_system_kotlin.mvp.contracts.ParkingReservationContract
import com.parking_system_kotlin.mvp.view.base.ActivityView
import com.parking_system_kotlin.utils.Constants
import com.parkingsystemkotlin.databinding.ActivityReservationBinding

class ParkingReservationView(activity: Activity, private val binding: ActivityReservationBinding) : ActivityView(activity),
    ParkingReservationContract.ParkingReservationView {

    override fun showDatePicker(listenerDateTime: ListenerDateTime, dateSelector: Boolean) {
        fragmentManager?.let {
            DateReservationDialogFragment.newInstance(listenerDateTime, dateSelector).show(it, Constants.DIALOG_FRAGMENT_ENTRY_DATE_PICKER)
        }
    }

    override fun showEntryDateSelected(date: String) {
        binding.editTextReservationActivityEntry.setText(date)
    }

    override fun showExitDateSelected(date: String) {
        binding.editTextReservationActivityExit.setText(date)
    }

    override fun closeScreen() {
        activity?.finish()
    }
}
