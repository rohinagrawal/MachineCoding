package RateLimiter;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Request {
    final double token;
    final User user;

    public Request(double token, User user){
        this.token = token;
        this.user = user;
    }
}
