package CabMatching;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Rider {
    private String name;
    private float rating;

    public Rider(String name){
        this.name = name;
        rating = 5;
    }
}
