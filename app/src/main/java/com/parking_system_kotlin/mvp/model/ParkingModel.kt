package com.parking_system_kotlin.mvp.model

import com.parking_system_kotlin.database.ReservationDatabase
import com.parking_system_kotlin.mvp.contracts.ParkingContract

class ParkingModel : ParkingContract.MainActivityModel {
    private val database: ReservationDatabase = ReservationDatabase

    override fun setParkingLots(parkingLots: String) {
        database.parkingLots = parkingLots
    }

    override fun getParkingLots(): String {
        return database.parkingLots
    }
}
