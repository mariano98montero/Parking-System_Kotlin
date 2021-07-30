package com.parking_system_kotlin.database

import com.parking_system_kotlin.entity.Reservation
import com.parking_system_kotlin.utils.Constants

object ReservationDatabase {
    private var reservations: HashMap<String, MutableList<Reservation>> = HashMap()
    private var parkingLots: String = Constants.EMPTY_STRING

    fun getParkingLots() = parkingLots

    fun setParkingLots(parkingLotSet: String) {
        this.parkingLots = parkingLotSet
    }

    fun addReservation(reservation: Reservation, parkingLot: String) {
        if (reservations.isEmpty()) {
            val reservationList: MutableList<Reservation> = mutableListOf(reservation)
            reservations[parkingLot] = reservationList
        } else {
            reservations[parkingLot]?.add(reservation)
        }
    }
}
