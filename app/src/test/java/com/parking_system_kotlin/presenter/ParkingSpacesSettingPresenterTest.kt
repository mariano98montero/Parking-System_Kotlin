package com.parking_system_kotlin.presenter

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.parking_system_kotlin.listeners.ListenerSetParkingDialogFragment
import com.parking_system_kotlin.mvp.contracts.ParkingSpacesSettingContract
import com.parking_system_kotlin.mvp.presenter.ParkingSpacesSettingPresenter
import org.junit.Test

class ParkingSpacesSettingPresenterTest {
    private val view: ParkingSpacesSettingContract.ParkingSpacesSettingDialogFragmentView = mock()
    private val presenter: ParkingSpacesSettingContract.ParkingSpacesSettingDialogFragmentPresenter = ParkingSpacesSettingPresenter(view)
    private val listener: ListenerSetParkingDialogFragment = mock()

    @Test
    fun ` on button dialog fragment spaces setting confirmation pressed test ok`() {
        presenter.onButtonDialogFragmentSpacesSettingConfirmationPressed(FIVE_STRING, listener)

        verify(view).showParkingLotsAvailable(FIVE_STRING, listener)
    }

    @Test
    fun ` on button dialog fragment spaces setting confirmation pressed test invalid input `() {
        presenter.onButtonDialogFragmentSpacesSettingConfirmationPressed(EMPTY_STRING, listener)

        verify(view).showInvalidValue()
    }

    companion object {
        private const val FIVE_STRING: String = "5"
        private const val EMPTY_STRING: String = ""
    }
}
