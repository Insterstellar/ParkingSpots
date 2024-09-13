package com.parkingspace.park.dtos;

import java.util.List;

public class UserParkingDTO {
    private int id;
    private String username;
    private boolean isAdded;
    private List<ParkingDTO> parkingFavorites;
    private SpotsAvailableDTO bookedSpot;

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

    public List<ParkingDTO> getParkingFavorites() {
        return parkingFavorites;
    }

    public void setParkingFavorites(List<ParkingDTO> parkingFavorites) {
        this.parkingFavorites = parkingFavorites;
    }

    public SpotsAvailableDTO getBookedSpot() {
        return bookedSpot;
    }

    public void setBookedSpot(SpotsAvailableDTO bookedSpot) {
        this.bookedSpot = bookedSpot;
    }

    @Override
    public String toString() {
        return "UserParkingDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", isAdded=" + isAdded +
                ", parkingFavorites=" + parkingFavorites +
                ", bookedSpot=" + bookedSpot +
                '}';
    }

// Getters and Setters
}

