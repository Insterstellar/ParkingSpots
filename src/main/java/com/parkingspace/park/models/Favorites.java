package com.parkingspace.park.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Favorites {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    boolean isAdded;

    @Transient
    @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "f_fk")
    List<Parking> parkingFavorites;

    public Favorites() {
    }

    public Favorites(int id, boolean isAdded, List<Parking> parkingFavorites) {
        this.id = id;
        this.isAdded = isAdded;
        this.parkingFavorites = parkingFavorites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    public List<Parking> getParkingFavorites() {
        return parkingFavorites;
    }

    public void setParkingFavorites(List<Parking> parkingFavorites) {
        this.parkingFavorites = parkingFavorites;
    }
}
