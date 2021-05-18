package RateLimiter;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterService {
    private Map<String, Bucket> userBucket;

    public RateLimiterService() {
        this.userBucket = new HashMap<>();
    }

    public boolean isAllowed(Request request){

        if (!userBucket.containsKey(request.getUser().getId()))
            generateBucket(request.getUser());

        Bucket bucket = userBucket.get(request.getUser().getId());
//        System.out.println("token requested : "+request.getToken());
        refill(bucket);
        if (bucket.getCurrentFilled()>=request.getToken()) {
            double currentBucket = bucket.getCurrentFilled();
            bucket.setCurrentFilled(currentBucket-request.getToken());
            return true;
        }
        return false;
    }

    private void generateBucket(User user){
        Bucket bucket = new Bucket(5,10000);
        userBucket.put(user.getId(), bucket);
    }

    private void refill(Bucket bucket){
        long now = System.nanoTime();
        double currentlyTokens = bucket.getCurrentFilled();
        double tokensToBeAdded = (now-bucket.getLastRefillTime()) * bucket.getRefillRate()/1e9;
//        System.out.println("Current: "+currentlyTokens);
//        System.out.println("Added: "+tokensToBeAdded);
        bucket.setCurrentFilled(Math.min(currentlyTokens + tokensToBeAdded, bucket.getBucketSize()));
        bucket.setLastRefillTime(now);
    }
}
