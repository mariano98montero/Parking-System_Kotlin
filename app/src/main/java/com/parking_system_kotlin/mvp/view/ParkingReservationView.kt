package com.parking_system_kotlin.mvp.view

import android.app.Activity
import android.widget.Toast
import com.parking_system_kotlin.entity.Reservation
import com.parking_system_kotlin.fragments.DateReservationDialogFragment
import com.parking_system_kotlin.listeners.ListenerDateTime
import com.parking_system_kotlin.mvp.contracts.ParkingReservationContract
import com.parking_system_kotlin.mvp.view.base.ActivityView
import com.parking_system_kotlin.utils.Constants
import com.parkingsystemkotlin.R
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

    private fun showMessage(messageID: Int) {
        context?.let {
            Toast.makeText(it, messageID, Toast.LENGTH_LONG)
                .show()
        }
    }

    override fun showConfirmationMessage() {
        showMessage(R.string.reservation_activity_text_confirmation_message)
    }

    override fun showErrorMessage() {
        showMessage(R.string.reservation_activity_text_parking_lot_error_message)
    }

    override fun closeScreen() {
        activity?.finish()
    }

    override fun getParkingLotSelected() = binding.editTextReservationActivityParkingNumber.text.toString()

    override fun getEntryDate() = binding.editTextReservationActivityEntry.text.toString()

    override fun getExitDate() = binding.editTextReservationActivityExit.text.toString()

    override fun getKeyCode() = binding.editTextReservationActivityCode.text.toString()
}
