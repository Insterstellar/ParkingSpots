package com.parkingspace.park.controllers;


import com.parkingspace.park.dtos.SpotsAvailableDTO;
import com.parkingspace.park.dtos.UserParkingDTO;
import com.parkingspace.park.models.Parking;
import com.parkingspace.park.models.SpotsAvailableModel;
import com.parkingspace.park.models.UserParking;
import com.parkingspace.park.services.SpotsServices;
import com.parkingspace.park.services.USerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    UserParkingDTO userParkingDTOList ;

    @Autowired
    USerServices userServices;
    @Autowired
    SpotsServices spotsServices;
    @PostMapping("/save/favorite/{userId}/{parkingId}")
    public UserParking saveFavorites(@PathVariable int userId, @PathVariable Long parkingId){
        return userServices.saveFavorites(parkingId, userId);
    }

    @PostMapping("/adduser")
     public UserParking addUser(@RequestBody UserParking addUserParking){
      return  userServices.addUser(addUserParking);

    }

    @GetMapping("/all/favorites/{id}")
    public ResponseEntity<List<Parking>> getAll(@PathVariable int id){
        List<Parking> favorites= userServices.getAllFavorites(id);
        return ResponseEntity.ok().body(favorites);
    }

    @DeleteMapping("/delete/favorite/{user_id}/{parking_id}")
    public List<Parking> deleteFavorite (@PathVariable int user_id, @PathVariable Long parking_id){
        return userServices.deleteFavorite(user_id,parking_id);
    }


    @GetMapping("activeNow")
    public SpotsAvailableModel bookedSpot(@RequestBody SpotsAvailableModel activeSpot){
        return  activeSpot;
    }


    //admin
    @GetMapping("/allusers")
    public List<UserParkingDTO> allUsers(){
       return  userServices.allUsers();
    }

    //for Tile purposes. To be omitted later
    @GetMapping("/allposts")
    public List<SpotsAvailableDTO> allSSpots(){
        return  spotsServices.allSpots();
    }


    @GetMapping("activespot/{user_id}")
    public ResponseEntity<UserParkingDTO> activeSpot(@PathVariable int user_id) throws ExecutionException, InterruptedException {
        return  ResponseEntity.ok(userServices.activeSPot(user_id));
    }
    @PatchMapping("/extendTime/{user_id}")
    public ResponseEntity<String> extendedParkingTome(@PathVariable int user_id, @RequestBody SpotsAvailableModel extendedTime){
        userServices.extendParkingTime(user_id,extendedTime);

        return ResponseEntity.ok("succeeded");
    }


    @GetMapping("/allReserved/{user_id}")
    public ResponseEntity<UserParkingDTO>allReservedSpots(@PathVariable int user_id){
       UserParkingDTO userParkingDTO=  userServices.allReservedSpots(user_id);

       if(userParkingDTO!=null){
           return  ResponseEntity.ok(userParkingDTO);
       }

       return  ResponseEntity.ok(userParkingDTO);

    }

    @PostMapping("/saveReservedSpot/{user_id}")
    public ResponseEntity <UserParkingDTO> saveReservedSPot(@PathVariable int user_id, @RequestBody SpotsAvailableModel spotsAvailableModel){
        UserParkingDTO  userParking= userServices.saveReservedSpots(user_id,spotsAvailableModel);
        return ResponseEntity.ok(userParking);
    }


    @GetMapping("/history/{user_id}")
    public ResponseEntity<UserParkingDTO> allHistory(@PathVariable int user_id){
        UserParkingDTO userParkingDTO =userServices.allHistory(user_id);
    System.out.println("hellow"+userParkingDTO);
    return ResponseEntity.ok(userParkingDTO);
    }


}
