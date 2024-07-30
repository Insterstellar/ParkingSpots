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
        return  parkingServices.getAllParking();
    }

    @PostMapping("/save")
    public  Parking saveParking(@RequestBody Parking saveParkingSpot){
        parkingSpot =parkingServices.saveParking(saveParkingSpot);
        return parkingSpot;
    }
    @PutMapping ("/update/{id}/{spotId}")
    public ResponseEntity<Parking> update (@RequestBody Parking parking, @PathVariable Long id,@PathVariable Long spotId){
        Parking updatedParking = parkingServices.updateParking(parking, id, spotId);
        System.out.println("am checking something here please"+ updatedParking);

        return  ResponseEntity.ok().body(updatedParking);
    }

    @PutMapping("updateSpot/{id}/{isAvailable}")
    public void updateSpot (@PathVariable Long id,@PathVariable boolean isAvailable){
        parkingServices.updateSpot(id,isAvailable);
    }






}
