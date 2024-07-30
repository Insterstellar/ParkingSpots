package com.parkingspace.park.models;

import jakarta.persistence.*;

@Entity
@Table(name = "GalleryImages")
public class GalleryImages {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id ;
    String imageUrl;


    public GalleryImages() {
    }

    public GalleryImages( String imageUrl) {
        //this.id = id;
        this.imageUrl = imageUrl;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getimageUrl() {
        return imageUrl;
    }

    public void setimageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
