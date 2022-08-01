import CabMatching.CabMatchingService;
import RateLimiter.BusinessService;
import RateLimiter.Request;
import RateLimiter.RateLimiterUser;
import Splitwise.SplitWiseUser;
import Splitwise.SplitWiseService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Machine Coding");
        cabMatchingMain();
        rateLimit();
        splitWise();
    }

    public static void cabMatchingMain(){
        CabMatchingService cabMatchingService = new CabMatchingService();
        cabMatchingService.initialize();
        cabMatchingService.trip("Ram");
        cabMatchingService.trip("Laxman");
    }

    public static void rateLimit(){
        RateLimiterUser rateLimiterUser = new RateLimiterUser("Ram");
        BusinessService businessService = new BusinessService();
        System.out.println(businessService.service(new Request(2, rateLimiterUser)).getMsg());
        System.out.println(businessService.service(new Request(1, rateLimiterUser)).getMsg());
        System.out.println(businessService.service(new Request(3, rateLimiterUser)).getMsg());
        System.out.println(businessService.service(new Request(4, rateLimiterUser)).getMsg());
        System.out.println(businessService.service(new Request(3, rateLimiterUser)).getMsg());
    }

    public static void splitWise() {
        SplitWiseUser splitWiseUser1 = new SplitWiseUser(1);
        SplitWiseUser splitWiseUser2 = new SplitWiseUser(2);
        SplitWiseUser splitWiseUser3 = new SplitWiseUser(3);
        SplitWiseUser splitWiseUser4 = new SplitWiseUser(4);

        SplitWiseService splitWiseService = new SplitWiseService();
        List<SplitWiseUser> expense1SplitWiseUsers = Arrays.asList(splitWiseUser1, splitWiseUser2, splitWiseUser3, splitWiseUser4);
        splitWiseService.addExpense(1,1000, splitWiseUser1, expense1SplitWiseUsers,"EQUAL",null);
        splitWiseService.addExpense(2,1000, splitWiseUser2, expense1SplitWiseUsers,"EQUAL",null);
        Map<SplitWiseUser,Integer> expense2Map = new HashMap<>();
        expense2Map.put(splitWiseUser1,250);
        expense2Map.put(splitWiseUser2,250);
        expense2Map.put(splitWiseUser3,500);
        expense2Map.put(splitWiseUser4,0);
        splitWiseService.addExpense(3,1000, splitWiseUser3, expense1SplitWiseUsers,"EXACT",expense2Map);
        Map<SplitWiseUser,Integer> expense3Map = new HashMap<>();
        expense3Map.put(splitWiseUser1,250);
        expense3Map.put(splitWiseUser2,250);
        expense3Map.put(splitWiseUser3,250);
        expense3Map.put(splitWiseUser4,250);
        splitWiseService.addExpense(4,1000, splitWiseUser3, expense1SplitWiseUsers,"EXACT",expense3Map);

        splitWiseService.printBalances(splitWiseService.getBalances());

        splitWiseService.printPaymentGraph(splitWiseService.getPaymentGraph(splitWiseService.getBalances()));
    }
}
