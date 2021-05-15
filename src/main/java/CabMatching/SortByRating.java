package CabMatching;

import java.util.Comparator;

public class SortByRating implements Comparator<Driver> {
    @Override
    public int compare(Driver a, Driver b) {
        return (int) (a.getRating()-b.getRating());
    }
}
