import CabMatching.CabMatchingService;
import RateLimiter.BusinessService;
import RateLimiter.Request;
import RateLimiter.Response;
import RateLimiter.User;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Machine Coding");
        cabMatchingMain();
        rateLimit();
    }

    public static void cabMatchingMain(){
        CabMatchingService cabMatchingService = new CabMatchingService();
        cabMatchingService.initialize();
        cabMatchingService.trip("Ram");
        cabMatchingService.trip("Laxman");
    }

    public static void rateLimit(){
        User user = new User("Ram");
        BusinessService businessService = new BusinessService();
        System.out.println(businessService.service(new Request(2,user)).getMsg());
        System.out.println(businessService.service(new Request(1,user)).getMsg());
        System.out.println(businessService.service(new Request(3,user)).getMsg());
        System.out.println(businessService.service(new Request(4,user)).getMsg());
        System.out.println(businessService.service(new Request(3,user)).getMsg());
    }
}
