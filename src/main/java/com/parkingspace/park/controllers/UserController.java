package com.parkingspace.park.controllers;


import com.parkingspace.park.models.Parking;
import com.parkingspace.park.models.UserParking;
import com.parkingspace.park.services.USerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    USerServices userServices;
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

    @GetMapping("/allusers")
    public List<UserParking> allUsers(){
       return  userServices.allUsers();
    }
}
