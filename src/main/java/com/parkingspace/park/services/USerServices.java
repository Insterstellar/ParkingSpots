package com.parkingspace.park.services;

import com.parkingspace.park.dtos.ParkingDTO;
import com.parkingspace.park.dtos.SpotsAvailableDTO;
import com.parkingspace.park.dtos.UserParkingDTO;
import com.parkingspace.park.interfaces.UserInterface;
import com.parkingspace.park.models.SpotsAvailableModel;
import com.parkingspace.park.models.UserParking;
import com.parkingspace.park.models.Parking;
import com.parkingspace.park.repository.UserRepository;
import com.parkingspace.park.repository.ParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Parking> allFavorites = new ArrayList<>();
        UserParking userParking = userRepository.findById(id).orElse(null);


         if(userParking !=null){
             allFavorites= userParking.getParkingFavorites();
             return allFavorites;
         }
         else {
             return allFavorites;
         }
        //userRepository.findAll();

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
    public List<UserParkingDTO> allUsers() {

        List<UserParking> user=userRepository.findAll();
        SpotsAvailableDTO spotsAvailableDTO = new SpotsAvailableDTO();
        List<UserParkingDTO> userDto = new ArrayList<>();
        for (UserParking userParking : user){
            SpotsAvailableModel model = userParking.getBookedSpot();
            spotsAvailableDTO.setId(model.getId());
            spotsAvailableDTO.setDuration(model.getDuration());
            spotsAvailableDTO.setEndTime(model.getEndTime());
            spotsAvailableDTO.setStartTime(model.getStartTime());
            spotsAvailableDTO.setOccupied(model.isIs_occupied());
            spotsAvailableDTO.setTotalPrice(model.getTotalPrice());
            spotsAvailableDTO.setQrCodeNumber(model.getQrCodeNumber());

            Parking parking = model.getParking();
            ParkingDTO parkingDTO = new ParkingDTO();

            parkingDTO.setDescription(parking.getDescription());
            parkingDTO.setDistance(parking.getDistance());
            parkingDTO.setNumberOfSpots(parking.getNumberOfSpots());
            parkingDTO.setLocation(parking.getLocation());
            parkingDTO.setPrice(parking.getPrice());
            parkingDTO.setName(parking.getName());
            parkingDTO.setId(parking.getId());

            spotsAvailableDTO.setParking(parkingDTO);



        }

       // List<UserParkingDTO> userDto1 = new ArrayList<>();
           for(UserParking userParking : user){
               UserParkingDTO userParkingDTO = new UserParkingDTO();
               userParkingDTO.setUsername(userParking.getUsername());
               userParkingDTO.setAdded(userParking.isAdded());
               userParkingDTO.setBookedSpot(spotsAvailableDTO);
               userParkingDTO.setId(userParking.getId());

               userDto.add(userParkingDTO);


              // userDto1.add(userParkingDTO);

           // userParkingDTO.setUsername("#####hello world o to the world");


    System.out.println("the parking for user 1 :-------------------------------+"+ userParkingDTO.toString());



           }

        return  userDto;
    }
}
