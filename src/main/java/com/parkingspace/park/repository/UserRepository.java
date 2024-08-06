package com.parkingspace.park.repository;

import com.parkingspace.park.models.UserParking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserParking, Integer> {
}
