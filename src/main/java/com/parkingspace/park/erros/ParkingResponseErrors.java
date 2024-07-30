package com.parkingspace.park.erros;

public class ParkingResponseErrors extends Exception{
    public ParkingResponseErrors() {
        super();
    }

    public ParkingResponseErrors(String message) {
        super(message);
    }

    public ParkingResponseErrors(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingResponseErrors(Throwable cause) {
        super(cause);
    }

    protected ParkingResponseErrors(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
