package com.parkingspace.park.controllers;


import com.parkingspace.park.models.Parking;
import com.parkingspace.park.models.SpotsAvailableModel;
import com.parkingspace.park.services.ParkingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/v1/parking")
public class ParkingController {
    @Autowired
    ParkingServices parkingServices;
    Parking parkingSpot;


    @GetMapping("/all")
    public  List<Parking> getAllParkingSPots(){
      List<Parking> parkingList = parkingServices.getAllParking();
        for (Parking p : parkingList){

           List <SpotsAvailableModel> s = p.getSpotAvailable();
            System.out.println("this the hello world test now ..........hello..."+parkingList.size());

            for(SpotsAvailableModel spotsAvailableModel : s){

           }

        }
        System.out.println("this the hello world test now .............");


        return  parkingServices.getAllParking();
    }

    @PostMapping("/save")
    public  Parking saveParking(@RequestBody Parking saveParkingSpot){
        parkingSpot =parkingServices.saveParking(saveParkingSpot);
        return parkingSpot;
    }
    @PutMapping ("/update/{id}")
    public ResponseEntity<Parking> update (@RequestBody Parking parking, @PathVariable Long id){
        Parking updatedParking = parkingServices.updateParking(parking, id);
        return  ResponseEntity.ok().body(updatedParking);
    }

    @PutMapping("/updateSpot/{user_id}")
    public void updateSpot (@RequestBody SpotsAvailableModel spotsAvailableModel,@PathVariable int user_id){
        System.out.println("hello world"+spotsAvailableModel.getStartTime().toString());

        parkingServices.updateSpot(user_id,spotsAvailableModel);
    }



    @PutMapping("addreview/{parking_id}/{user_id}")
    public ResponseEntity<Parking> addReview(@RequestBody Parking review, @PathVariable Long parking_id, @PathVariable int user_id ){
        Parking park = parkingServices.addReview(review,parking_id,user_id);
        System.out.println("am testing this code now ---------!!!!!!-");

        return ResponseEntity.ok(park);

    };



}
