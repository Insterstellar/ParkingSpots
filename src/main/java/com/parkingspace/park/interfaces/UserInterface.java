package com.parkingspace.park.interfaces;

import com.parkingspace.park.models.Parking;
import com.parkingspace.park.models.UserParking;

import java.util.List;

public interface UserInterface {
    UserParking saveFavorites (Long parkingId, int userId);
    List<Parking> getAllFavorites(int id);
   List<Parking> deleteFavorite(int user_id, Long parking_id);

    UserParking addUser(UserParking addUserParking);
    List<UserParking> allUsers();
}
