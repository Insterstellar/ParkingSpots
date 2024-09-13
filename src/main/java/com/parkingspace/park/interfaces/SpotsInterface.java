package com.parkingspace.park.interfaces;

import com.parkingspace.park.dtos.SpotsAvailableDTO;
import com.parkingspace.park.models.SpotsAvailableModel;

import java.util.List;

public interface SpotsInterface {
    List<SpotsAvailableDTO> allSpots();
}
