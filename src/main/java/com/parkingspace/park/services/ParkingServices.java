package com.parkingspace.park.services;

import com.parkingspace.park.interfaces.ParkingInterface;
import com.parkingspace.park.models.Parking;
import com.parkingspace.park.models.SpotsAvailableModel;
import com.parkingspace.park.repository.ParkingRepo;
import com.parkingspace.park.repository.SpotsAvailableModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingServices implements ParkingInterface {
    @Autowired
    ParkingRepo parkingRepo;
    @Autowired
    SpotsAvailableModelRepo spotsAvailableModelRepo;
    Parking parking;
    SpotsAvailableModel spots;

    //get all parking spots
    @Override
    public List<Parking> getAllParking() {
        return parkingRepo.findAll();
    }

    //save parking
    @Override
    public Parking saveParking(Parking saveParkingSpot) {

        if (saveParkingSpot == null) {
            return parking;
        } else {
            List<SpotsAvailableModel> spotsAvailableModels = saveParkingSpot.getSpotAvailable();

            for (int i = 0; i < saveParkingSpot.getNumberOfSpots(); i++) {
                spotsAvailableModels.add(i, new SpotsAvailableModel());

            }

            return parkingRepo.save(saveParkingSpot);
        }

    }
    public Parking updateParking(Parking parking, Long id, Long spotId) {
        List<SpotsAvailableModel> spotsAvailableModel1 = new ArrayList<>();
        System.out.println("check for changes  --1------" + parking.getName());
        Parking upateParking = parkingRepo.findById(id).orElse(parking);
        upateParking.setName(parking.getName());

        SpotsAvailableModel spotsAvailableModel = spotsAvailableModelRepo.findById(spotId).orElse(null);

        for (SpotsAvailableModel spotModel : upateParking.getSpotAvailable()) {
            spotsAvailableModel.setIs_occupied(spotModel.isIs_occupied());

        }
        spotsAvailableModel1.add(spotsAvailableModel);
        upateParking.setSpotAvailable(spotsAvailableModel1);
        parkingRepo.save(upateParking);

        System.out.println("check for changes --2------" + upateParking.getId());
        System.out.println("check for changes --3------" + upateParking.getName());
        return parkingRepo.save(upateParking);
    }

    public void updateSpot(Long id, boolean isAvailable) {
        SpotsAvailableModel spotsAvailableModel = spotsAvailableModelRepo.findById(id).orElse(null);
        spotsAvailableModel.setIs_occupied(isAvailable);
        spotsAvailableModelRepo.save(spotsAvailableModel);


    }
}
