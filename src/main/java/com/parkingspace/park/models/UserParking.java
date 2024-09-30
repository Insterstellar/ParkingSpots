package com.parkingspace.park.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
public class UserParking {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    String username;
    boolean isAdded;
    String profileImage;

   // @Transient
   @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
   @JoinTable(name = "user_parking_favorite",
    joinColumns = @JoinColumn(name = "user_parking_id"),
    inverseJoinColumns = @JoinColumn(name = "parking_id"))
   List<Parking> parkingFavorites =new ArrayList<>();

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "spFk")
   SpotsAvailableModel bookedSpot;
   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "rs_fk")
   Set<SpotsAvailableModel> reservedSpot ;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bkhs_fk")
   List<SpotsAvailableModel> bookHistory;






    public UserParking() {
    }

    public UserParking(int id, String username, boolean isAdded, List<Parking> parkingFavorites, SpotsAvailableModel bookedSpot,Set<SpotsAvailableModel> reservedSpot,String profileImage, List<SpotsAvailableModel> bookHistory) {
        this.id = id;
        this.username = username;
        this.isAdded = isAdded;
        this.parkingFavorites = parkingFavorites;
        this.bookedSpot = bookedSpot;
        this.reservedSpot=reservedSpot;
        this.profileImage=profileImage;
        this.bookHistory = bookHistory;
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

    public SpotsAvailableModel getBookedSpot() {
        return bookedSpot;
    }

    public void setBookedSpot(SpotsAvailableModel bookedSpot) {
        this.bookedSpot = bookedSpot;
    }

    public Set<SpotsAvailableModel> getReservedSpot() {
        return reservedSpot;
    }

    public void setReservedSpot(Set<SpotsAvailableModel> reservedSpot) {
        this.reservedSpot = reservedSpot;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public List<SpotsAvailableModel> getBookHistory() {
        return bookHistory;
    }

    public void setBookHistory(List<SpotsAvailableModel> bookHistory) {
        this.bookHistory = bookHistory;
    }
}
