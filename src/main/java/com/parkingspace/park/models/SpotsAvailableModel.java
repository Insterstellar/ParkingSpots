package com.parkingspace.park.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class SpotsAvailableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    boolean is_occupied=true;
    int duration;
    double totalPrice;
    LocalDateTime startTime;
    LocalDateTime endTime;
   // @Transient
    @ManyToOne( fetch = FetchType.EAGER)
     @JoinColumn(name = "spot_fk")
    @JsonBackReference
    Parking parking;
    double qrCodeNumber;


    public SpotsAvailableModel() {
    }

    public SpotsAvailableModel( boolean is_occupied, int duration, double totalPrice, LocalDateTime startTime, LocalDateTime endTime,  double qrCodeNumber) {
        //this.id = id;
        this.is_occupied = is_occupied;
        this.duration = duration;
        this.totalPrice = totalPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        //this.parking = parking;
        this.qrCodeNumber = qrCodeNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isIs_occupied() {
        return is_occupied;
    }

    public void setIs_occupied(boolean is_occupied) {
        this.is_occupied = is_occupied;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public double getQrCodeNumber() {
        return qrCodeNumber;
    }

    public void setQrCodeNumber(double qrCodeNumber) {
        this.qrCodeNumber = qrCodeNumber;
    }

    @Override
    public String toString() {
        return "SpotsAvailableModel{" +
                "id=" + id +
                ", is_occupied=" + is_occupied +
                ", duration=" + duration +
                ", totalPrice=" + totalPrice +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", parking=" + parking +
                ", qrCodeNumber=" + qrCodeNumber +
                '}';
    }
}
