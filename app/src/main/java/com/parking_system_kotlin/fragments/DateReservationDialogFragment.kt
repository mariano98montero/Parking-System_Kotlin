package com.parking_system_kotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.parking_system_kotlin.listeners.ListenerDateTime
import com.parking_system_kotlin.mvp.contracts.ParkingDatePickerContract
import com.parking_system_kotlin.mvp.presenter.ParkingDatePickerPresenter
import com.parking_system_kotlin.mvp.view.ParkingDatePickerView
import com.parking_system_kotlin.utils.Constants
import com.parkingsystemkotlin.databinding.DialogFragmentDatePickerBinding

class DateReservationDialogFragment : DialogFragment() {

    private lateinit var binding: DialogFragmentDatePickerBinding
    private lateinit var presenter: ParkingDatePickerContract.ParkingDatePickerPresenter
    private lateinit var listenerDateTime: ListenerDateTime

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DialogFragmentDatePickerBinding.inflate(inflater, container, false)
        presenter = ParkingDatePickerPresenter(
            ParkingDatePickerView(this, binding),
            arguments?.getBoolean(Constants.DATE_SELECTOR_BOOLEAN)
        )

        listenerDateTime = arguments?.getSerializable(Constants.LISTENER_DATE_PICKER_KEY) as ListenerDateTime
        setListeners()
        return binding.root
    }

    companion object {
        fun newInstance(listenerDateTime: ListenerDateTime, dateSelector: Boolean): DateReservationDialogFragment {
            val entryReservationDialogFragment = DateReservationDialogFragment()
            val bundle = Bundle()
            bundle.apply {
                putBoolean(Constants.DATE_SELECTOR_BOOLEAN, dateSelector)
                putSerializable(Constants.LISTENER_DATE_PICKER_KEY, listenerDateTime)
            }
            entryReservationDialogFragment.arguments = bundle
            return entryReservationDialogFragment
        }
    }

    private fun setListeners() {
        binding.buttonReservationDialogFragmentConfirm.setOnClickListener {
            presenter.onButtonDialogFragmentDatePickerConfirmationPressed(
                listenerDateTime
            )
        }
        binding.buttonReservationDialogFragmentCancel.setOnClickListener { presenter.closeDateDialog() }
    }
}
