package com.parking_system_kotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.parking_system_kotlin.listeners.ListenerDateTime
import com.parking_system_kotlin.mvp.contracts.ParkingReservationContract
import com.parking_system_kotlin.mvp.model.ParkingReservationModel
import com.parking_system_kotlin.mvp.presenter.ParkingReservationPresenter
import com.parking_system_kotlin.mvp.view.ParkingReservationView
import com.parkingsystemkotlin.databinding.ActivityReservationBinding
import java.util.Calendar

class ReservationActivity : AppCompatActivity(), ListenerDateTime {

    private lateinit var binding: ActivityReservationBinding
    private lateinit var presenter: ParkingReservationContract.ParkingReservationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = ParkingReservationPresenter(ParkingReservationModel(), ParkingReservationView(this, binding))

        setListeners()
    }

    private fun setListeners() {
        with(binding) {
            editTextReservationActivityEntry.setOnClickListener { presenter.showDatePicker(this@ReservationActivity, true) }
            editTextReservationActivityExit.setOnClickListener { presenter.showDatePicker(this@ReservationActivity, false) }
            buttonReservationActivitySave.setOnClickListener { presenter.saveReservation() }
        }
    }

    override fun setEntryDate(entryDate: Calendar) {
        presenter.setEntryDate(entryDate)
    }

    override fun setExitDate(exitDate: Calendar) {
        presenter.setExitDate(exitDate)
    }

    companion object {
        fun newInstance(context: Context): Intent = Intent(context, ReservationActivity::class.java)
    }
}
