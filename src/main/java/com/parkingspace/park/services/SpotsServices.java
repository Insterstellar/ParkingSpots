package com.parkingspace.park.services;

import com.parkingspace.park.dtos.ParkingDTO;
import com.parkingspace.park.dtos.SpotsAvailableDTO;
import com.parkingspace.park.interfaces.SpotsInterface;
import com.parkingspace.park.models.Parking;
import com.parkingspace.park.models.SpotsAvailableModel;
import com.parkingspace.park.repository.SpotsAvailableModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SpotsServices implements SpotsInterface {
    @Autowired
    SpotsAvailableModelRepo spotsAvailableModelRepo;
    @Override
    public List<SpotsAvailableDTO> allSpots() {
        List<SpotsAvailableModel> spot = spotsAvailableModelRepo.findAll();
      List<SpotsAvailableDTO>  lists =new ArrayList<>();

        for (SpotsAvailableModel spotsAvailableModel : spot){
            SpotsAvailableDTO spotsAvailableDTO = new SpotsAvailableDTO();

            spotsAvailableDTO.setId(spotsAvailableModel.getId());
            spotsAvailableDTO.setDuration(spotsAvailableModel.getDuration());
            spotsAvailableDTO.setEndTime(spotsAvailableModel.getEndTime());
            spotsAvailableDTO.setStartTime(spotsAvailableModel.getStartTime());
            spotsAvailableDTO.setOccupied(spotsAvailableModel.isIs_occupied());
            spotsAvailableDTO.setTotalPrice(spotsAvailableModel.getTotalPrice());
            spotsAvailableDTO.setQrCodeNumber(spotsAvailableModel.getQrCodeNumber());


            ParkingDTO parkingDTO = getParkingDTO(spotsAvailableModel);

            spotsAvailableDTO.setParking(parkingDTO);
            lists.add(spotsAvailableDTO);







        }

        return lists;
    }

    private static ParkingDTO getParkingDTO(SpotsAvailableModel spotsAvailableModel) {
        ParkingDTO parkingDTO = new ParkingDTO();
        Parking parking = spotsAvailableModel.getParking();
        parkingDTO.setDescription(parking.getDescription());
        parkingDTO.setDistance(parking.getDistance());
        parkingDTO.setNumberOfSpots(parking.getNumberOfSpots());
        parkingDTO.setLocation(parking.getLocation());
        parkingDTO.setPrice(parking.getPrice());
        parkingDTO.setName(parking.getName());
        parkingDTO.setId(parking.getId());
        return parkingDTO;
    }
}
