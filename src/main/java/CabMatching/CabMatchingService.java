package CabMatching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CabMatchingService {
    private ArrayList<Rider> riders;
    private ArrayList<Driver> drivers;
    private ArrayList<Trip> trips;

    public CabMatchingService() {
        this.riders = new ArrayList<>();
        this.drivers = new ArrayList<>();
        this.trips = new ArrayList<>();
    }

    public void initialize(){
        addRider("Ram");
        addRider("Laxman");
        addRider("Bharat");
        addDriver("Bheem");
        addDriver("Nakul");
        addDriver("Sahadev");
        addTrip("Ram","Bheem",3,5);
        addTrip("Laxman","Nakul",5,2);
        addTrip("Ram","Sahadev",4,2);
        addTrip("Bharat","Bheem",3,5);
        addTrip("Ram","Bheem",3,1);
        addTrip("Laxman","Sahadev",5,3);
        addTrip("Bharat", "Nakul",5,5);
    }

    public void addRider(String name){
        Rider rider = new Rider(name);
        riders.add(rider);
    }

    public void addDriver(String name){
        Driver driver = new Driver(name);
        drivers.add(driver);
    }

    public void addTrip(String riderName, String driverName, float riderRating, float driverRating){
        Rider rider = riders.stream().filter(rider1 -> rider1.getName().equals(riderName)).findFirst().orElse(null);
        Driver driver = drivers.stream().filter(driver1 -> driver1.getName().equals(driverName)).findFirst().orElse(null);
        Trip trip = new Trip(driver,rider, driverRating,riderRating);
        trips.add(trip);

        if(rider!=null)
        updateRiderRating(rider, riderRating);

        if (driver!=null)
        updateDriverRating(driver, driverRating);
    }

    public void trip(String riderName){
        Rider rider = riders.stream().filter(rider1 -> rider1.getName().equals(riderName)).findFirst().orElse(null);
        Driver driver = matchDriver(rider);
        System.out.println(driver.getName() + " " + driver.getRating());
    }

    public Driver matchDriver(Rider rider){
//        TODO: Review Business Logic
        List<Driver> notAllowed = trips.stream()
                .filter(trip -> trip.getRider().equals(rider) && (trip.getDriverRating() <= 1 || trip.getRiderRating() <= 1))
                .map(Trip::getDriver).collect(Collectors.toList());
        drivers.sort(new Driver.SortByRating());
        return drivers.stream().filter(driver -> !notAllowed.contains(driver)).findFirst().orElse(null);
    }

    public void updateRiderRating(Rider rider,float riderRating){
        float oldRating = rider.getRating();
        int n = rider.getTrips();
        rider.setTrips(n+1);
        float currRating = ((oldRating * n) + riderRating)/(n+1);
        rider.setRating(currRating);
    }

    public void updateDriverRating(Driver driver, float driverRating){
        float oldRating = driver.getRating();
        int n = driver.getTrips();
        driver.setTrips(n+1);
        float currRating = ((oldRating * n) + driverRating)/(n+1);
        driver.setRating(currRating);
    }
}
