import CabMatching.CabMatchingService;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Machine Coding");
        CabMatchingMain();
    }

    public static void CabMatchingMain(){
        CabMatchingService cabMatchingService = new CabMatchingService();
        cabMatchingService.initialize();
        cabMatchingService.trip("Ram");
        cabMatchingService.trip("Laxman");
    }
}
