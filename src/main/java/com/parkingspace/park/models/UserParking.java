package com.parkingspace.park.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class UserParking {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    String username;
    boolean isAdded;

   // @Transient
   @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
   @JoinTable(name = "user_parking_favorite",
           joinColumns = @JoinColumn(name = "user_parking_id"),
           inverseJoinColumns = @JoinColumn(name = "parking_id"))
   List<Parking> parkingFavorites =new ArrayList<>();

    public UserParking() {
    }

    public UserParking(int id, String username, boolean isAdded, List<Parking> parkingFavorites) {
        this.id = id;
        this.username = username;
        this.isAdded = isAdded;
        this.parkingFavorites = parkingFavorites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        this.parkingFavorites = new ArrayList<>(parkingFavorites);
    }
}
