package com.parkingspace.park.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Parking")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;
    String location;
    String price;
    String distance;
    int numberOfSpots;
   @OneToMany(mappedBy = "parking", orphanRemoval = true,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  // @JoinColumn(name = "parking_fk")
   @JsonManagedReference
    List<SpotsAvailableModel> spotAvailable =new ArrayList<>();

   @OneToMany(cascade = CascadeType.ALL)
     @JoinColumn(name ="rvpk_Fk")
    List<ReviewParking>reviewParking=new ArrayList<>();


    //work to do about coordinates
    String coordinates;
    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "parking_fk")
    List<GalleryImages> gallery;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parking_fk")
    List<Amenities> amenities;

    public Parking() {
    }



    public Parking( String name, String description, String location, String price, String distance, int numberOfSpots, String coordinates, List<GalleryImages> gallery, List<Amenities> amenities) {
       // this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.price = price;
        this.distance = distance;
        this.numberOfSpots = numberOfSpots;
        //this.spotAvailable = spotAvailable;

        this.coordinates = coordinates;
        this.gallery = gallery;
        this.amenities = amenities;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDistance() {
        return distance;
    }


    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getNumberOfSpots() {
        return numberOfSpots;
    }

    public void setNumberOfSpots(int numberOfSpots) {
        this.numberOfSpots = numberOfSpots;
    }

    public List<SpotsAvailableModel> getSpotAvailable() {
        return spotAvailable;
    }

    public void setSpotAvailable(List<SpotsAvailableModel> spotAvailable) {
        this.spotAvailable = spotAvailable;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public List<GalleryImages> getGallery() {
        return gallery;
    }

    public void setGallery(List<GalleryImages> gallery) {
        this.gallery = gallery;
    }

    public List<Amenities> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenities> amenities) {
        this.amenities = amenities;
    }

    public List<ReviewParking> getReviewParking() {
        return reviewParking;
    }

    public void setReviewParking(List<ReviewParking> reviewParking) {
        this.reviewParking = reviewParking;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", price='" + price + '\'' +
                ", distance='" + distance + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", gallery=" + gallery +
                ", amenities=" + amenities +
                '}';
    }
}
