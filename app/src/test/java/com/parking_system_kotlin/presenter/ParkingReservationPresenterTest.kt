package com.parking_system_kotlin.presenter

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.parking_system_kotlin.listeners.ListenerDateTime
import com.parking_system_kotlin.mvp.contracts.ParkingReservationContract
import com.parking_system_kotlin.mvp.presenter.ParkingReservationPresenter
import com.parking_system_kotlin.utils.getStringFromDate
import com.parking_system_kotlin.entity.Reservation
import org.junit.Test
import java.util.Calendar
import java.util.GregorianCalendar

class ParkingReservationPresenterTest {
    private val view: ParkingReservationContract.ParkingReservationView = mock()
    private val model: ParkingReservationContract.ParkingReservationModel = mock()
    private val presenter: ParkingReservationContract.ParkingReservationPresenter = ParkingReservationPresenter(model, view)
    private val listener: ListenerDateTime = mock()
    private val PARKING_LOT = "5"
    private val EMPTY_STRING = ""
    private val KEY_CODE = "543"
    private val YEAR = 2021
    private val MONTH = 8
    private val ENTRY_DAY = 16
    private val HOUR = 13
    private val MINUTE = 12

    private fun getCalendar(): Calendar {
        return GregorianCalendar(YEAR, MONTH, ENTRY_DAY, HOUR, MINUTE)
    }

    private fun getReservation() = Reservation(getCalendar().getStringFromDate(), getCalendar().getStringFromDate(), KEY_CODE)

    @Test
    fun ` show date picker test `() {
        presenter.showDatePicker(listener, true)

        verify(view).showDatePicker(listener, true)
    }

    @Test
    fun ` set entry date test `() {
        presenter.setEntryDate(getCalendar())

        verify(view).showEntryDateSelected(getCalendar().getStringFromDate())
    }

    @Test
    fun ` set exit date test `() {
        presenter.setExitDate(getCalendar())

        verify(view).showExitDateSelected(getCalendar().getStringFromDate())
    }

    @Test
    fun ` save reservation ok test `() {
        whenever(view.getEntryDate()).thenReturn(getCalendar().getStringFromDate())
        whenever(view.getExitDate()).thenReturn(getCalendar().getStringFromDate())
        whenever(view.getKeyCode()).thenReturn(KEY_CODE)
        whenever(view.getParkingLotSelected()).thenReturn(PARKING_LOT)

        presenter.saveReservation()

        verify(model).addReservation(getReservation(), PARKING_LOT)
        verify(view).showConfirmationMessage()
        verify(view).closeScreen()
    }

    @Test
    fun ` save reservation failed test `() {
        whenever(view.getParkingLotSelected()).thenReturn(EMPTY_STRING)
        presenter.saveReservation()

        verify(view).showErrorMessage()
    }
}
