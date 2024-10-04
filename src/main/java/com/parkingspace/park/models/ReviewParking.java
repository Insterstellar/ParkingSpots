package com.parkingspace.park.models;

import jakarta.persistence.*;


@Entity

public class ReviewParking {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    int id ;
    String comment;
    int stars;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk")
    UserParking userParkingName;

    public ReviewParking() {
    }

    public ReviewParking(String comment, UserParking userParkingName,int stars, int id) {
       this.id=id;
        this.comment = comment;
        this.userParkingName = userParkingName;
        this.stars=stars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserParking getUserParkingName() {
        return userParkingName;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setUserParkingName(UserParking userParkingName) {
        this.userParkingName = userParkingName;
    }


    @Override
    public String toString() {
        return "ReviewParking{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", stars=" + stars +
                ", userParkingName=" + userParkingName +
                '}';
    }
}
