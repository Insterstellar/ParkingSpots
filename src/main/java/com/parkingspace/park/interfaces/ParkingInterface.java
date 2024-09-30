package com.parkingspace.park.interfaces;

import com.parkingspace.park.models.Parking;
import com.parkingspace.park.models.ReviewParking;
import com.parkingspace.park.models.SpotsAvailableModel;

import java.util.List;

public interface ParkingInterface {
    List<Parking> getAllParking ();
    Parking saveParking(Parking saveParkingSpot);
    Parking addReview (ReviewParking review, Long parking_id, int user_id);

    void updateSpot(int user_id, SpotsAvailableModel spotsAvailableModel);

}
