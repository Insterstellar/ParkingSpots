package com.parkingspace.park;

import com.parkingspace.park.controllers.ParkingController;
import com.parkingspace.park.services.ParkingServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootApplication
public class ParkApplication {
	public static void main(String[] args) {
		SpringApplication.run(ParkApplication.class, args);
		//LocalDateTime.parse("2024-08-31 17:38:00.000")
		//LocalDateTime localDateTime = LocalDateTime.of(2024 ,4 ,4,,0,0,0)
		;

		String raster ="2024-08-31 17:38:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("yyyy-MM-dd HH:mm:ss"));
		LocalDateTime localDateTime = LocalDateTime.parse(raster,formatter);




		System.out.println("hellow this is the current time "+LocalDateTime.now() );
	}

}
