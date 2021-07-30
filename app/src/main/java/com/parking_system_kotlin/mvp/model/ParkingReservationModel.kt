package com.parking_system_kotlin.mvp.model

import com.parking_system_kotlin.database.ReservationDatabase
import com.parking_system_kotlin.entity.Reservation
import com.parking_system_kotlin.mvp.contracts.ParkingReservationContract

class ParkingReservationModel : ParkingReservationContract.ParkingReservationModel {
    private val database: ReservationDatabase = ReservationDatabase
    override fun addReservation(reservation: Reservation, parkingLot: String) {
        database.addReservation(reservation, parkingLot)
    }
}
