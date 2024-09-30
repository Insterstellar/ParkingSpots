package com.parkingspace.park;

import com.parkingspace.park.controllers.ParkingController;
import com.parkingspace.park.services.ParkingServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;

import static com.zaxxer.hikari.util.ClockSource.currentTime;

@SpringBootApplication
public class ParkApplication {
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(ParkApplication.class, args);
		//LocalDateTime.parse("2024-08-31 17:38:00.000")
		//LocalDateTime localDateTime = LocalDateTime.of(2024 ,4 ,4,,0,0,0)
		;

		//String raster ="2024-08-31 17:38:00";
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("yyyy-MM-dd HH:mm:ss"));
		//LocalDateTime localDateTime = LocalDateTime.parse(raster,formatter);
		LocalDateTime localDateTime = LocalDateTime.of(2024,9,25,9,3);


		//LocalTime currentTime = LocalTime.now();

		//LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		Timer timer = new Timer();

		MyTaski myTaski = new MyTaski();

		Date two = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());


		//System.out.println("hello world this is the begining of the world"+ two);

		//timer.
		//timer.schedule(myTaski,  two);
		//timer.cancel();











	}


}


