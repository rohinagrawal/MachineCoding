package CabMatching;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
public class Driver{
    String name;
    float rating;

    public Driver(String name){
        this.name = name;
        rating=5;
    }

    public static class SortByRating implements Comparator<Driver> {
        @Override
        public int compare(Driver a, Driver b) {
            return (int) (a.getRating()-b.getRating());
        }
    }
}
