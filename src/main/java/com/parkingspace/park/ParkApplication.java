package com.parkingspace.park;

import com.parkingspace.park.controllers.ParkingController;
import com.parkingspace.park.services.ParkingServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkApplication.class, args);
	}

}
