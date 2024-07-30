package com.parkingspace.park.repository;

import com.parkingspace.park.models.Amenities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenitiesRepo extends JpaRepository<Amenities, Long> {
}
