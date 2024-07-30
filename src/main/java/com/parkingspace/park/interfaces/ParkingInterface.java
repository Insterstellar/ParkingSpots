package com.parkingspace.park.interfaces;

import com.parkingspace.park.models.Parking;

import java.util.List;

public interface ParkingInterface {
    List<Parking> getAllParking ();
    Parking saveParking(Parking saveParkingSpot);

}
