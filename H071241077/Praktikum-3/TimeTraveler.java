public class TimeTraveler {
    String name;
    String currentLocation;
    TimeMachine timeMachine;

    public TimeTraveler() {
        this.name = "Diesty";
        this.currentLocation = "Abad-21";
        this.timeMachine = new TimeMachine();
    }

    public TimeTraveler(String name, String currentLocation, TimeMachine timeMachine) {
        this.name = name;
        this.currentLocation = currentLocation;
        this.timeMachine = timeMachine;
    }

    public void tampilkanInfo() {
        System.out.println("Nama : " + name);
        System.out.println("Lokasi saat ini : " + currentLocation);
        timeMachine.tampilkanTimeMachine();
    }

    public void swapLocation(TimeTraveler other) {
        String lokasiSementara = this.currentLocation;
        this.currentLocation = other.currentLocation;
        other.currentLocation = lokasiSementara;
        System.out.println(this.name + " dan " + other.name + " bertukar lokasi.\n");
    }
}



