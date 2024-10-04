package com.parkingspace.park.dtos;

import com.parkingspace.park.models.SpotsAvailableModel;

import java.util.ArrayList;
import java.util.List;

public class UserParkingDTO {
    private int id;
    private String username;
    String profileImage;
    private boolean isAdded;
    private List<ParkingDTO> parkingFavorites;
    private List<SpotsAvailableDTO> reservedParking =new ArrayList<>();
    private SpotsAvailableDTO bookedSpot;
    List<SpotsAvailableDTO> bookHistory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
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

    public List<SpotsAvailableDTO> getReservedParking() {
        return reservedParking;
    }

    public void setReservedParking(List<SpotsAvailableDTO> reservedParking) {
        this.reservedParking = reservedParking;
    }

    public List<SpotsAvailableDTO> getBookHistory() {
        return bookHistory;
    }

    public void setBookHistory(List<SpotsAvailableDTO> bookHistory) {
        this.bookHistory = bookHistory;
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

