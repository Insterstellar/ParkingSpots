package com.parkingspace.park.repository;

import com.parkingspace.park.models.ReviewParking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingReviewRepo extends JpaRepository<ReviewParking, Integer> {
}
