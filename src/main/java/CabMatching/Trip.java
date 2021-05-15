package CabMatching;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Trip {
    private Driver driver;
    private Rider rider;

    private float driverRating;
    private float riderRating;
}
