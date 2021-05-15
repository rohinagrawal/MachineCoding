package CabMatching;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private float rating;

    void person(String name){
        this.name = name;
        rating = 5;
    }
}
