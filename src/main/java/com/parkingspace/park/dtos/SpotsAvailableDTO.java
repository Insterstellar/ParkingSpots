package com.parkingspace.park.dtos;

import java.time.LocalDateTime;

public class SpotsAvailableDTO {
    private Long id;
    private boolean isOccupied;
    private int duration;
    private double totalPrice;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private double qrCodeNumber;
    private ParkingDTO parking;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
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

    public ParkingDTO getParking() {
        return parking;
    }

    public void setParking(ParkingDTO parking) {
        this.parking = parking;
    }

    public void setQrCodeNumber(double qrCodeNumber) {
        this.qrCodeNumber =qrCodeNumber;
    }

    public double getQrCodeNumber() {
        return qrCodeNumber;
    }

    @Override
    public String toString() {
        return "SpotsAvailableDTO{" +
                "id=" + id +
                ", isOccupied=" + isOccupied +
                ", duration=" + duration +
                ", totalPrice=" + totalPrice +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", qrCodeNumber=" + qrCodeNumber +
                ", parking=" + parking +
                '}';
    }
}
