package RateLimiter;

import lombok.Getter;

import java.util.UUID;

@Getter
public class User {
    String id;
    String name;

    public User(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
