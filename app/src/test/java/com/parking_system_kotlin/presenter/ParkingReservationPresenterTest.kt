package com.parking_system_kotlin.presenter

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.parking_system_kotlin.listeners.ListenerDateTime
import com.parking_system_kotlin.mvp.contracts.ParkingReservationContract
import com.parking_system_kotlin.mvp.presenter.ParkingReservationPresenter
import com.parking_system_kotlin.utils.getStringFromDate
import org.junit.Test
import java.util.Calendar
import java.util.GregorianCalendar

class ParkingReservationPresenterTest {
    private val view: ParkingReservationContract.ParkingReservationView = mock()
    private val presenter: ParkingReservationContract.ParkingReservationPresenter = ParkingReservationPresenter(view)
    private val listener: ListenerDateTime = mock()
    private val YEAR = 2021
    private val MONTH = 8
    private val ENTRY_DAY = 16
    private val HOUR = 1
    private val MINUTE = 12

    private fun getCalendar(): Calendar {
        val calendar: Calendar = GregorianCalendar()
        calendar[YEAR, MONTH, ENTRY_DAY, HOUR] =
            MINUTE
        return calendar
    }

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
    fun ` save reservation test `() {
        presenter.saveReservation()

        verify(view).closeScreen()
    }
}
