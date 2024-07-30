package com.parkingspace.park.dto;

import com.parkingspace.park.models.Amenities;
import com.parkingspace.park.models.GalleryImages;

import java.util.List;

public class ParkingDto {
    Long id;

    String name;
    String description;
    String location;
    String price;
    String distance;

    //work to do about coordinates
    String coordinates;

    List<GalleryImages> gallery;

    List<Amenities> amenities;

    public ParkingDto() {
    }

    public ParkingDto(Long id, String name, String description, String location, String price, String distance, String coordinates, List<GalleryImages> gallery, List<Amenities> amenities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.price = price;
        this.distance = distance;
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
