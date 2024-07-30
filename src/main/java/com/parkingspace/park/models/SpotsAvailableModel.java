package com.parkingspace.park.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SpotsAvailableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    boolean is_occupied=true;

    public SpotsAvailableModel() {
    }

    public SpotsAvailableModel(Long id, boolean is_occupied) {
        this.id = id;
        this.is_occupied = is_occupied;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isIs_occupied() {
        return is_occupied;
    }

    public void setIs_occupied(boolean is_occupied) {
        this.is_occupied = is_occupied;
    }
}
