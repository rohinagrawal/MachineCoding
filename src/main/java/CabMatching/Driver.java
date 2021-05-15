package CabMatching;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver{
    String name;
    float rating;

    public Driver(String name){
        this.name = name;
        rating=5;
    }
}
