package com.parking_system_kotlin.presenter

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.parking_system_kotlin.listeners.ListenerDateTime
import com.parking_system_kotlin.mvp.contracts.ParkingDatePickerContract
import com.parking_system_kotlin.mvp.presenter.ParkingDatePickerPresenter
import org.junit.Test

class ParkingDatePickerPresenterTest {
    private val listener: ListenerDateTime = mock()
    private val view: ParkingDatePickerContract.ParkingDatePickerView = mock()
    private val presenterEntryDate: ParkingDatePickerContract.ParkingDatePickerPresenter = ParkingDatePickerPresenter(view, true)

    @Test
    fun ` show entry reservation date test `() {
        presenterEntryDate.onButtonDialogFragmentDatePickerConfirmationPressed(listener)

        verify(view).showEntryReservationDate(listener)
    }

    @Test
    fun ` show exit reservation date test `() {
        val presenterExitDate: ParkingDatePickerContract.ParkingDatePickerPresenter = ParkingDatePickerPresenter(view, false)
        presenterExitDate.onButtonDialogFragmentDatePickerConfirmationPressed(listener)

        verify(view).showExitReservationDate(listener)
    }

    @Test
    fun ` close date dialog test `() {
        presenterEntryDate.closeDateDialog()

        verify(view).closeDateDialog()
    }
}
