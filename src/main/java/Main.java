import CabMatching.CabMatchingService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Machine Coding");
        CabMatchingService cabMatchingService = new CabMatchingService();
        cabMatchingService.initalize();
        cabMatchingService.trip("Ram");
        cabMatchingService.trip("Laxman");
    }
}
