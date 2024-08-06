package com.parkingspace.park.services;

import com.parkingspace.park.interfaces.UserInterface;
import com.parkingspace.park.models.UserParking;
import com.parkingspace.park.models.Parking;
import com.parkingspace.park.repository.UserRepository;
import com.parkingspace.park.repository.ParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class USerServices implements UserInterface {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ParkingRepo parkingRepo;
    @Override
    public UserParking saveFavorites(Long parkingId, int userId) {
        Parking parking = parkingRepo.findById(parkingId).orElse(null);
        UserParking userParking = userRepository.findById(userId).orElse(null);


//TO_DO excpetions to be handled later
        List<Parking> parkingList = userParking.getParkingFavorites();
            parkingList.add(parking);


        userParking.setParkingFavorites(parkingList);

        return userRepository.save(userParking);

    }

    @Override
    public List<Parking> getAllFavorites(int id) {
        UserParking userParking = userRepository.findById(id).orElse(null);
        List<Parking> allFavorites= userParking.getParkingFavorites();
        //userRepository.findAll();
        return allFavorites;
    }

    @Override
    public List<Parking> deleteFavorite(int user_id, Long parking_id) {
       // Parking parkin=;
        UserParking userParking = userRepository.findById(user_id).orElse(null);
        Parking parking1 = parkingRepo.findById(parking_id).orElse(null);
        List<Parking> parking = userParking.getParkingFavorites();
        parking.remove(parking1);
        userParking.setParkingFavorites(parking);
        userRepository.save(userParking);
        parking=userParking.getParkingFavorites();
        return parking;
    }

    @Override
    public UserParking addUser(UserParking addUserParking) {
        return userRepository.save(addUserParking);
    }

    @Override
    public List<UserParking> allUsers() {
        return userRepository.findAll();
    }
}
