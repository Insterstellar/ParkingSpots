package com.parkingspace.park.services;

import com.parkingspace.park.dtos.ParkingDTO;
import com.parkingspace.park.dtos.SpotsAvailableDTO;
import com.parkingspace.park.dtos.UserParkingDTO;
import com.parkingspace.park.interfaces.UserInterface;
import com.parkingspace.park.models.SpotsAvailableModel;
import com.parkingspace.park.models.UserParking;
import com.parkingspace.park.models.Parking;
import com.parkingspace.park.repository.SpotsAvailableModelRepo;
import com.parkingspace.park.repository.UserRepository;
import com.parkingspace.park.repository.ParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.*;

@Service
public class USerServices implements UserInterface {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ParkingRepo parkingRepo;

    @Autowired
   private SpotsAvailableModelRepo spotsAvailableModelRepo;
    int seconds=0;
    int newTime =0;
    @Override
    public UserParking saveFavorites(Long parkingId, int userId) {
        Parking parking = parkingRepo.findById(parkingId).orElse(null);
        UserParking userParking = userRepository.findById(userId).orElse(null);

//TO_DO excpetions to be handled later
        List<Parking> parkingList = userParking.getParkingFavorites();
            parkingList.add(parking);


        userParking.setParkingFavorites(parkingList);

        return userRepository.save(userParking);

    }

    @Override
    public List<Parking> getAllFavorites(int id) {
        List<Parking> allFavorites = new ArrayList<>();
        UserParking userParking = userRepository.findById(id).orElse(null);


         if(userParking !=null){
             allFavorites= userParking.getParkingFavorites();
             return allFavorites;
         }
         else {
             return allFavorites;
         }
        //userRepository.findAll();

    }

    @Override
    public List<Parking> deleteFavorite(int user_id, Long parking_id) {

        UserParking userParking = userRepository.findById(user_id).orElse(null);
        Parking parking1 = parkingRepo.findById(parking_id).orElse(null);
        List<Parking> parking = userParking.getParkingFavorites();
        parking.remove(parking1);
        userParking.setParkingFavorites(parking);
        userRepository.save(userParking);
        parking=userParking.getParkingFavorites();
        return parking;
    }

    @Override
    public UserParking addUser(UserParking addUserParking) {
        return userRepository.save(addUserParking);
    }

    @Override
    public List<UserParkingDTO> allUsers() {

        List<UserParking> user=userRepository.findAll();
        SpotsAvailableDTO spotsAvailableDTO = new SpotsAvailableDTO();
        List<UserParkingDTO> userDto = new ArrayList<>();
        for (UserParking userParking : user){
            SpotsAvailableModel model = userParking.getBookedSpot();
            spotsAvailableDTO.setId(model.getId());
            spotsAvailableDTO.setDuration(model.getDuration());
            spotsAvailableDTO.setEndTime(model.getEndTime());
            spotsAvailableDTO.setStartTime(model.getStartTime());
            spotsAvailableDTO.setOccupied(model.isIs_occupied());
            spotsAvailableDTO.setTotalPrice(model.getTotalPrice());
            spotsAvailableDTO.setQrCodeNumber(model.getQrCodeNumber());

            Parking parking = model.getParking();
            ParkingDTO parkingDTO = new ParkingDTO();

            parkingDTO.setDescription(parking.getDescription());
            parkingDTO.setDistance(parking.getDistance());
            parkingDTO.setNumberOfSpots(parking.getNumberOfSpots());
            parkingDTO.setLocation(parking.getLocation());
            parkingDTO.setPrice(parking.getPrice());
            parkingDTO.setName(parking.getName());
            parkingDTO.setId(parking.getId());

            spotsAvailableDTO.setParking(parkingDTO);



        }

       // List<UserParkingDTO> userDto1 = new ArrayList<>();
           for(UserParking userParking : user){
               UserParkingDTO userParkingDTO = new UserParkingDTO();
               userParkingDTO.setUsername(userParking.getUsername());
               userParkingDTO.setAdded(userParking.isAdded());
               userParkingDTO.setBookedSpot(spotsAvailableDTO);
               userParkingDTO.setId(userParking.getId());

               userDto.add(userParkingDTO);

    System.out.println("the parking for user 1 :-------------------------------+"+ userParkingDTO.toString());



           }

        return  userDto;
    }

    @Override
    public UserParkingDTO activeSPot(int user_id) throws ExecutionException, InterruptedException {
        UserParkingDTO userParkingDTO = new UserParkingDTO();

        UserParking activeSpot = userRepository.findById(user_id).orElse(null);
        SpotsAvailableModel spotsAvailableModel = activeSpot.getBookedSpot();


       //int newTimae= times(spotsAvailableModel.getDuration());
        if(activeSpot!=null && spotsAvailableModel!=null){
            LocalDateTime startdate =spotsAvailableModel.getStartTime();
            LocalDateTime enddate =spotsAvailableModel.getEndTime();
            LocalTime endTime = LocalTime.of(enddate.getHour(), enddate.getMinute());
            LocalTime currentTime = LocalTime.now();
            LocalTime check = LocalTime.of(13,30);
             //LocalTime checkfirst = LocalTime.of(1,21);

            Duration remainingDuration = Duration.between(currentTime, endTime);


           LocalTime remainingTime;
            if(remainingDuration.isNegative()){
                List<SpotsAvailableModel> addToHistory = new ArrayList<>();
                addToHistory.add(spotsAvailableModel);
                activeSpot.setBookHistory(addToHistory);
                userRepository.save(activeSpot);
                remainingTime=LocalTime.MIDNIGHT;
                activeSpot.setBookedSpot(null);
                userRepository.save(activeSpot);

                System.out.println("------------time is less than 0   :"+remainingDuration.toHoursPart()+":"+remainingDuration.toMinutesPart()+ ":"+remainingDuration.toSecondsPart());

            }else {
              remainingTime = LocalTime.of((int)remainingDuration.toHours(),(int)remainingDuration.toMinutesPart(),(int)remainingDuration.toSecondsPart());

                System.out.println("------------ postive   :"+remainingDuration.toHoursPart()+":"+remainingDuration.toMinutesPart()+ ":"+remainingDuration.toSecondsPart());

            }




             SpotsAvailableDTO spotsAvailableDTO =new SpotsAvailableDTO();
             spotsAvailableDTO.setDuration(spotsAvailableModel.getDuration());
             spotsAvailableDTO.setRemainingTime(remainingTime );
             spotsAvailableDTO.setStartTime(spotsAvailableModel.getStartTime());
             spotsAvailableDTO.setEndTime(spotsAvailableModel.getEndTime());
             spotsAvailableDTO.setQrCodeNumber(spotsAvailableModel.getQrCodeNumber());
             spotsAvailableDTO.setTotalPrice(spotsAvailableModel.getTotalPrice());
             spotsAvailableDTO.setId(spotsAvailableModel.getId());

             Parking parking = spotsAvailableModel.getParking();
             ParkingDTO parkingDTO = new ParkingDTO();
             parkingDTO.setName(parking.getName());
             parkingDTO.setDescription(parking.getDescription());
             parkingDTO.setPrice(parking.getPrice());
             parkingDTO.setLocation(parking.getLocation());
             parkingDTO.setDistance(parking.getDistance());
             parkingDTO.setId(parking.getId());


             spotsAvailableDTO.setParking(parkingDTO);
            //userParking=activeSpot;
            userParkingDTO.setUsername(activeSpot.getUsername());
            userParkingDTO.setBookedSpot(spotsAvailableDTO);
            userParkingDTO.setId(activeSpot.getId());
            userParkingDTO.setProfileImage(activeSpot.getProfileImage());

            return userParkingDTO;

        }else {
            System.out.println("this here-------" );

            List<SpotsAvailableModel> tagg=activeSpot.getBookHistory();
            for(SpotsAvailableModel walter : tagg){
                System.out.println("this here-------"+ walter.getId() );
            }

            return userParkingDTO;
        }

    }

    @Override
    public void extendParkingTime(int user_id, SpotsAvailableModel extendTime) {
        UserParking userParking =userRepository.findById(user_id).orElse(null);
        LocalDateTime newExtendedTime = extendTime.getEndTime();

        if(userParking !=null){
           SpotsAvailableModel spotsAvailableModel=userParking.getBookedSpot();
           LocalDateTime localDateTime = spotsAvailableModel.getEndTime()
                   .plusHours(newExtendedTime.getHour())
                   .plusMinutes(newExtendedTime.getMinute())
                   .plusSeconds(newExtendedTime.getSecond());



           spotsAvailableModel.setEndTime(localDateTime);
           double newTotalPrice=userParking.getBookedSpot().getTotalPrice()+ extendTime.getTotalPrice();
           spotsAvailableModel.setTotalPrice(newTotalPrice);

           userParking.setBookedSpot(spotsAvailableModel);

           userRepository.save(userParking);
        }


    }

    @Override
    public UserParkingDTO saveReservedSpots(int user_id, SpotsAvailableModel reservedSpots) {
        UserParkingDTO emptyDto = new UserParkingDTO();

        UserParking userParking = userRepository.findById(user_id).orElse(null);
        SpotsAvailableModel updateModel = spotsAvailableModelRepo.findById(reservedSpots.getId()).orElse(null);
        if(userParking!=null && updateModel !=null){

            updateModel.setTotalPrice(reservedSpots.getTotalPrice());
            //updateModel.setParking(reservedSpots.getParking());
            updateModel.setQrCodeNumber(reservedSpots.getQrCodeNumber());
            updateModel.setDuration(reservedSpots.getDuration());
            updateModel.setStartTime(reservedSpots.getStartTime());
            updateModel.setEndTime(reservedSpots.getEndTime());


            Set<SpotsAvailableModel> reservedSpotList = userParking.getReservedSpot();

                reservedSpotList.remove(updateModel);
                reservedSpotList.add(updateModel);



            userParking.setReservedSpot(reservedSpotList);

            userRepository.save(userParking);


            Set<SpotsAvailableModel> spotsList = userParking.getReservedSpot();
            List<SpotsAvailableDTO> spotsAvailableDTOS =new ArrayList<>();
            for(SpotsAvailableModel updateList : spotsList){
                SpotsAvailableDTO availableDTO = new SpotsAvailableDTO();

                availableDTO.setTotalPrice(updateList.getTotalPrice());
                availableDTO.setStartTime(updateList.getStartTime());
                availableDTO.setEndTime(updateList.getEndTime());
                availableDTO.setQrCodeNumber(updateList.getQrCodeNumber());
                availableDTO.setId(updateList.getId());

                Parking parking = updateList.getParking();

                ParkingDTO parkingDTO = new ParkingDTO();
                parkingDTO.setId(parking.getId());
                parkingDTO.setPrice(parking.getPrice());
                parkingDTO.setName(parking.getName());
                parkingDTO.setLocation(parking.getLocation());
                parkingDTO.setDescription(parking.getDescription());

                availableDTO.setParking(parkingDTO);
                spotsAvailableDTOS.add(availableDTO);

            }

            UserParkingDTO userParkingDTO = new UserParkingDTO();

            userParkingDTO.setUsername(userParking.getUsername());
            userParkingDTO.setProfileImage(userParking.getProfileImage());
            userParkingDTO.setReservedParking(spotsAvailableDTOS);

return  userParkingDTO;

        }
        return emptyDto ;
    }

    @Override
    public UserParkingDTO allReservedSpots(int user_id)  {
    UserParkingDTO userParkingLIst = new UserParkingDTO();

        UserParking reservedSpot =userRepository.findById(user_id).orElse(null);
        if(reservedSpot!=null){
            Set<SpotsAvailableModel> reservedSpots= reservedSpot.getReservedSpot();


            System.out.println("he≤re ids the new list"+reservedSpots.size());
            List<SpotsAvailableDTO> spotsAvailableDTOList = new ArrayList<>();

            for(SpotsAvailableModel newReserved : reservedSpots){
                SpotsAvailableDTO spotsAvailableDTO = new SpotsAvailableDTO();
                spotsAvailableDTO.setId(newReserved.getId());
                spotsAvailableDTO.setRemainingTime(null);
                spotsAvailableDTO.setTotalPrice(newReserved.getTotalPrice());
                spotsAvailableDTO.setQrCodeNumber(newReserved.getQrCodeNumber());
                spotsAvailableDTO.setStartTime(newReserved.getStartTime());
                spotsAvailableDTO.setEndTime(newReserved.getEndTime());
                spotsAvailableDTO.setDuration(newReserved.getDuration());

                Parking parking =newReserved.getParking();
                ParkingDTO parkingDTO = new ParkingDTO();
                parkingDTO.setId(parking.getId());
                parkingDTO.setName(parking.getName());
                parkingDTO.setLocation(parking.getLocation());
                parkingDTO.setPrice(parking.getPrice());

                spotsAvailableDTO.setParking(parkingDTO);

                spotsAvailableDTOList.add(spotsAvailableDTO);

            }
            UserParkingDTO userParkingDTO = new UserParkingDTO();

            userParkingDTO.setUsername(reservedSpot.getUsername());
            userParkingDTO.setId(reservedSpot.getId());
            userParkingDTO.setProfileImage(reservedSpot.getProfileImage());
            userParkingDTO.setReservedParking(spotsAvailableDTOList);

            userParkingLIst =userParkingDTO;


                UserParking allReservedSpots = userRepository.findById(user_id).orElse(null);

               Set<SpotsAvailableModel> list = allReservedSpots.getReservedSpot();

              for(SpotsAvailableModel spotsAvailableModel : list){
                   LocalDateTime localDateTime =spotsAvailableModel.getStartTime();

                   Date delayTime = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
                  Timer timer = new Timer();
                  timer.schedule(new TimerTask() {
                      @Override
                      public void run() {
                          try {
                              Thread.sleep(1000l);
                              reservedSpot.setBookedSpot(spotsAvailableModel);
                              userRepository.save(reservedSpot);
                          } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                          }

                       list.remove(spotsAvailableModel);

                        userRepository.save(allReservedSpots);

                      }
                  },delayTime);
               }

            return userParkingLIst;

        }else {

            return userParkingLIst;

        }

    }

    @Override
    public UserParkingDTO allHistory(int user_id) {
        UserParkingDTO userParkingDTOS = new UserParkingDTO();
        //to be refactored later and handle exceptions.
        List<SpotsAvailableDTO> historyList =new ArrayList<>();
        UserParking userHistory = userRepository.findById(user_id).orElse(null);

        if(userHistory!=null){
            List<SpotsAvailableModel> history =userHistory.getBookHistory();
            for (SpotsAvailableModel model : history){
          SpotsAvailableDTO availableDTO = new  SpotsAvailableDTO();

                availableDTO.setTotalPrice(model.getTotalPrice());
        availableDTO.setStartTime(model.getStartTime());
        availableDTO.setEndTime(model.getEndTime());
        availableDTO.setDuration(model.getDuration());
                Parking parking = model.getParking();
                ParkingDTO parkingDTO =new  ParkingDTO();
        parkingDTO.setId(parking.getId());
        parkingDTO.setPrice(parking.getPrice());
        parkingDTO.setLocation(parking.getLocation());
        parkingDTO.setName(parking.getName());

        availableDTO.setParking(parkingDTO);
                historyList.add(availableDTO);
        userParkingDTOS.setUsername(userHistory.getUsername());
                userParkingDTOS.setBookHistory(historyList);

            }






            return userParkingDTOS ;

        }

        return userParkingDTOS ;
    }


    public static CompletableFuture<LocalTime> times(LocalTime timeDuration)   {

        CompletableFuture<LocalTime> future = new CompletableFuture<>();


        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Runnable task to run every second
        Runnable countdownTask = new Runnable() {
            LocalTime currentTime = timeDuration;


            @Override
            public void run() {

                if (!currentTime.equals(LocalTime.MIDNIGHT)) { // Stop when time reaches 00:00:00
                    System.out.println("Time remaining: " + currentTime);
                    currentTime = currentTime.minusSeconds(1);
                    future.complete(currentTime);// Subtract one second from the time

                } else {
                    System.out.println("Countdown complete!");
                    scheduler.shutdown(); // Stop the scheduler when countdown reaches zero
                }
            }

        };



        // Schedule the countdown task to run every second
       scheduler.scheduleAtFixedRate(countdownTask, 0, 1, TimeUnit.SECONDS);



        return future;

    }
}
