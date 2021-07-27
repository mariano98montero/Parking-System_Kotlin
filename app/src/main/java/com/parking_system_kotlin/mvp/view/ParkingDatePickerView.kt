package com.parking_system_kotlin.mvp.view

import androidx.fragment.app.Fragment
import com.parking_system_kotlin.fragments.DateReservationDialogFragment
import com.parking_system_kotlin.listeners.ListenerDateTime
import com.parking_system_kotlin.mvp.contracts.ParkingDatePickerContract
import com.parking_system_kotlin.mvp.view.base.FragmentView
import com.parkingsystemkotlin.databinding.DialogFragmentDatePickerBinding
import java.util.Calendar
import java.util.GregorianCalendar

class ParkingDatePickerView(fragment: Fragment, private val binding: DialogFragmentDatePickerBinding) :
    ParkingDatePickerContract.ParkingDatePickerView, FragmentView(fragment) {

    private fun getCalentar(): Calendar {
        val fragment: DateReservationDialogFragment = fragment as DateReservationDialogFragment
        val calendar: Calendar = GregorianCalendar()
        calendar.set(
            binding.datePickerDialogFragment.year,
            binding.datePickerDialogFragment.month,
            binding.datePickerDialogFragment.dayOfMonth,
            binding.timePickerDialogFragment.hour,
            binding.timePickerDialogFragment.minute
        )
        fragment.dismiss()
        return calendar
    }

    override fun showEntryReservationDate(listenerDateTime: ListenerDateTime) {
        listenerDateTime.setEntryDate(getCalentar())
    }

    override fun showExitReservationDate(listenerDateTime: ListenerDateTime) {
        listenerDateTime.setExitDate(getCalentar())
    }

    override fun closeDateDialog() {
        val dialogFragment: DateReservationDialogFragment = fragment as DateReservationDialogFragment
        dialogFragment.dismiss()
    }
}
