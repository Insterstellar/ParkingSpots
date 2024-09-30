package com.parkingspace.park.interfaces;

import com.parkingspace.park.dtos.UserParkingDTO;
import com.parkingspace.park.models.Parking;
import com.parkingspace.park.models.SpotsAvailableModel;
import com.parkingspace.park.models.UserParking;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserInterface {
    UserParking saveFavorites (Long parkingId, int userId);
    List<Parking> getAllFavorites(int id);
   List<Parking> deleteFavorite(int user_id, Long parking_id);

    UserParking addUser(UserParking addUserParking);
    List<UserParkingDTO> allUsers();

    UserParkingDTO activeSPot(int user_id) throws ExecutionException, InterruptedException;

    void extendParkingTime(int user_id, SpotsAvailableModel extendTime);

    UserParkingDTO saveReservedSpots(int user_id, SpotsAvailableModel reservedSpots);

   UserParkingDTO allReservedSpots(int user_id);


}
