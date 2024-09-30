package com.parkingspace.park;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.HOURS;

public class MyTaski extends TimerTask {
    @Override
    public void run() {

        //Duration duration = Duration.ofHours(1);
        LocalTime today = LocalTime.of(1,0,0);
        System.out.println("Intital time ---- : "+today.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        int seconds = 0;

      /*  while (true){
            seconds--;
         LocalTime newTime=   today.plusSeconds(seconds);
         if(newTime.getHour()==0 && newTime.getMinute() == 0 && newTime.getSecond()==0){
             System.out.println("The time has stopped tadda");

             break;
         }
System.out.println("new time ---- : "+newTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }*/






       // int dur = du













    }
}
