package CabMatching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CabMatchingService {
    private ArrayList<Rider> riders = new ArrayList();
    private ArrayList<Driver> drivers = new ArrayList();
    private ArrayList<Trip> trips = new ArrayList();

    public void addRider(String name){
        Rider rider = new Rider(name);
        riders.add(rider);
    }

    public void addDriver(String name){
        Driver driver = new Driver(name);
        drivers.add(driver);
    }

    public void addTrip(Rider rider, Driver driver, float riderRating, float driverRating){
        Trip trip = new Trip(driver,rider, driverRating,riderRating);
        trips.add(trip);
        updateRiderRating(rider, riderRating);
        updateDriverRating(driver, driverRating);
    }

    public void trip(String riderName){
        Rider rider = riders.stream().filter(rider1 -> rider1.getName().equals(riderName)).findFirst().orElse(null);
        Driver driver = matchDriver(rider);
    }

    public Driver matchDriver(Rider rider){
//        TODO: Business Logic
        Driver driver=null;
//        ArrayList<Driver> badRatingDriver = new ArrayList();
//        List<Trip> driver = trips.stream().filter(trip -> trip.getRider().equals(rider)).map(trip -> {
//            if (trip.getDriverRating()<=1){
//                badRatingDriver.add(trip.getDriver());
//            }
//            return trip;
//        }).collect(Collectors.toList());
//        list1.stream().filter()
        return driver;
    }

    public void updateRiderRating(Rider rider,float riderRating){
        float oldRating = rider.getRating();
        float currRating = oldRating + riderRating;
        rider.setRating(currRating);
    }

    public void updateDriverRating(Driver driver, float driverRating){
        float oldRating = driver.getRating();
        float currRating = oldRating + driverRating;
        driver.setRating(currRating);
    }
}
