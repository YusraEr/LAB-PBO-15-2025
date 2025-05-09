public class Main {
    public static void main(String[] args) {
        TimeMachine tm = new TimeMachine("Model Supersonic");
        TimeTraveler a = new TimeTraveler("Anya", "Masa Depan", tm);
        TimeTraveler b = new TimeTraveler();

        a.tampilkanInfo();
        System.out.println();

        b.tampilkanInfo();
        System.out.println();

        System.out.println("Sebelum tukar:");
        System.out.println(a.name + " berada di " + a.currentLocation);
        System.out.println(b.name + " berada di " + b.currentLocation);
        
        a.swapLocation(b);
        
        System.out.println("Setelah tukar:");
        System.out.println(a.name + " sekarang di " + a.currentLocation);
        System.out.println(b.name + " sekarang di " + b.currentLocation);
    }
}

