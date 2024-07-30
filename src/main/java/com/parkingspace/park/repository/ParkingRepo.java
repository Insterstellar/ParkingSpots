package com.parkingspace.park.repository;

import com.parkingspace.park.models.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepo extends JpaRepository<Parking,Long> {
}
