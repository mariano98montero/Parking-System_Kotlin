package com.parking_system_kotlin.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.parking_system_kotlin.listeners.ListenerSetParkingDialogFragment
import com.parking_system_kotlin.mvp.contracts.ParkingContract
import com.parking_system_kotlin.mvp.model.ParkingModel
import com.parking_system_kotlin.mvp.presenter.ParkingPresenter
import com.parking_system_kotlin.mvp.view.ParkingView
import com.parkingsystemkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ListenerSetParkingDialogFragment {
    private lateinit var presenter: ParkingContract.MainActivityPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = ParkingPresenter(ParkingModel(), ParkingView(this))

        setListeners()
    }

    private fun setListeners() {
        with(binding) {
            buttonMainActivitySelectParkingSpace.setOnClickListener { presenter.onSetParkingButtonPressed(this@MainActivity) }
            buttonMainActivityReservation.setOnClickListener { presenter.onReservationButtonPressed() }
        }
    }

    override fun listenFreeSpaces(freeSpaces: String) {
        presenter.setParkingSpacesAvailable(freeSpaces)
    }
}
