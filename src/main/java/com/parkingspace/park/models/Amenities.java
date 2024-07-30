package com.parkingspace.park.models;


import jakarta.annotation.Generated;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Amenities")
public class Amenities {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;
    String name;


    public Amenities() {
    }

    public Amenities( String name, long id) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
