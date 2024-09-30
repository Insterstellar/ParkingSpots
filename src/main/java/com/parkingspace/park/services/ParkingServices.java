package com.parkingspace.park.services;

import com.parkingspace.park.interfaces.ParkingInterface;
import com.parkingspace.park.models.Parking;
import com.parkingspace.park.models.ReviewParking;
import com.parkingspace.park.models.SpotsAvailableModel;
import com.parkingspace.park.models.UserParking;
import com.parkingspace.park.repository.ParkingRepo;
import com.parkingspace.park.repository.ParkingReviewRepo;
import com.parkingspace.park.repository.SpotsAvailableModelRepo;
import com.parkingspace.park.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingServices implements ParkingInterface {
    @Autowired
    ParkingRepo parkingRepo;
    @Autowired
    SpotsAvailableModelRepo spotsAvailableModelRepo;
   // Parking parking;
    SpotsAvailableModel spots;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ParkingReviewRepo parkingReviewRepo;

    Parking parking;

    //get all parking spots
    @Override
    public List<Parking> getAllParking() {


        return parkingRepo.findAll();
    }

    //save parking
    @Override
    public Parking saveParking(Parking saveParkingSpot) {
        Parking parking = new Parking(

                saveParkingSpot.getName(),
                saveParkingSpot.getDescription(),
                saveParkingSpot.getLocation(),
                saveParkingSpot.getPrice(),
                saveParkingSpot.getDistance(),
                saveParkingSpot.getNumberOfSpots(),
                saveParkingSpot.getCoordinates(),
                saveParkingSpot.getGallery(),
                saveParkingSpot.getAmenities()


        );
       // Parking park = new Parking();


        if (saveParkingSpot == null) {
            return new Parking();
        } else {

            List<SpotsAvailableModel> spotsAvailableModels = saveParkingSpot.getSpotAvailable();
           for (int i = 0; i < saveParkingSpot.getNumberOfSpots(); i++) {
               SpotsAvailableModel spots = new  SpotsAvailableModel();

               spots.setParking(parking);
                spotsAvailableModels.add(spots);

           }

           parking.setSpotAvailable(spotsAvailableModels);




            return parkingRepo.save(parking);
        }

    }

    @Override
    public Parking addReview(ReviewParking review, Long parking_id, int user_id) {
        //  parking and user entities
        Parking oldReview = parkingRepo.findById(parking_id).orElse(null);
        UserParking userParking = userRepository.findById(user_id).orElse(null);

        if (oldReview == null || userParking == null) {

            return null;
        }


        List<ReviewParking> existingReviews = oldReview.getReviewParking();
        ReviewParking userExistingReview = null;


        for (ReviewParking rp : existingReviews) {
            if (rp.getUserParkingName().getId() == user_id) {
                userExistingReview = rp;
                break;
            }
        }


        if (userExistingReview != null) {


                userExistingReview.setComment(review.getComment());
                userExistingReview.setStars(review.getStars());
                //userExistingReview.setUserParkingName(userParking);



        } else {

            ReviewParking newReview = new ReviewParking();
                newReview.setComment(review.getComment());
                newReview.setStars(review.getStars());
                newReview.setUserParkingName(userParking);

            existingReviews.add(newReview);
        }


        oldReview.setReviewParking(existingReviews);

        return parkingRepo.save(oldReview);
    }

    @Override
    public void updateSpot(int user_id, SpotsAvailableModel spotsAvailableModel) {
        UserParking userSpot = userRepository.findById(user_id).orElse(null);
        SpotsAvailableModel exisistingSpotsAvailableModel = spotsAvailableModelRepo.findById(spotsAvailableModel.getId()).orElse(null);
        if(exisistingSpotsAvailableModel !=null){

            exisistingSpotsAvailableModel.setParking(spotsAvailableModel.getParking());
            exisistingSpotsAvailableModel.setEndTime(spotsAvailableModel.getEndTime());
            exisistingSpotsAvailableModel.setStartTime(spotsAvailableModel.getStartTime());
            exisistingSpotsAvailableModel.setTotalPrice(spotsAvailableModel.getTotalPrice());
            exisistingSpotsAvailableModel.setDuration(spotsAvailableModel.getDuration());
            exisistingSpotsAvailableModel.setIs_occupied(spotsAvailableModel.isIs_occupied());
            exisistingSpotsAvailableModel.setQrCodeNumber(spotsAvailableModel.getQrCodeNumber());
            spotsAvailableModelRepo.save(exisistingSpotsAvailableModel);

        }

        userSpot.setBookedSpot(exisistingSpotsAvailableModel);

        userRepository.save(userSpot);




    }

    public Parking updateParking(Parking parking, Long id) {
        List<SpotsAvailableModel> spotsAvailableModel1 = new ArrayList<>();
        System.out.println("check for changes  --1------" + parking.getName());
        Parking upateParking = parkingRepo.findById(id).orElse(parking);
        upateParking.setName(parking.getName());

       //SpotsAvailableModel spotsAvailableModel = spotsAvailableModelRepo.findById(spotId).orElse(null);
       //
       //for (SpotsAvailableModel spotModel : upateParking.getSpotAvailable()) {
       //    spotsAvailableModel.setIs_occupied(spotModel.isIs_occupied());
       //
       //}
       //spotsAvailableModel1.add(spotsAvailableModel);
       //upateParking.setSpotAvailable(spotsAvailableModel1);
        parkingRepo.save(upateParking);

        //System.out.println("check for changes --2------" + upateParking.getId());
        System.out.println("check for changes --3------" + upateParking.getName());
        return parkingRepo.save(upateParking);
    }



}
