package com.parkingspace.park.repository;

import com.parkingspace.park.models.SpotsAvailableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpotsAvailableModelRepo extends JpaRepository<SpotsAvailableModel, Long> {
}
