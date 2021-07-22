package com.parking_system_kotlin.presenter

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.parking_system_kotlin.listeners.ListenerSetParkingDialogFragment
import com.parking_system_kotlin.mvp.contracts.ParkingContract
import com.parking_system_kotlin.mvp.model.ParkingModel
import com.parking_system_kotlin.mvp.presenter.ParkingPresenter
import junit.framework.Assert.assertEquals
import org.junit.Test

class ParkingPresenterTest {
    private val listener: ListenerSetParkingDialogFragment = mock()
    private val view: ParkingContract.MainActivityView = mock()
    private val model: ParkingContract.MainActivityModel = ParkingModel()
    private val presenter: ParkingContract.MainActivityPresenter = ParkingPresenter(model, view)

    @Test
    fun ` on set parking button pressed test `() {
        presenter.onSetParkingButtonPressed(listener)

        verify(view).showDialogFragment(listener)
    }

    @Test
    fun ` set parking spaces available test `() {
        presenter.setParkingSpacesAvailable(FIVE_STRING)

        verify(view).showParkingLotsAvailable(FIVE_STRING)
        assertEquals(FIVE_STRING, model.getParkingLots())
    }

    companion object {
        private const val FIVE_STRING: String = "5"
    }
}
