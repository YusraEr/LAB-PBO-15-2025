public class Main {
    public static void main(String[] args) {
        Senjata pedangApi = new Senjata("Pedang Api", 30);
        PowerRanger rangerMerah = new PowerRanger("Jason", "Merah", 100, pedangApi);
        PowerRanger rangerBiru = new PowerRanger("Billy", "Biru", 100, new Senjata("Tombak Es", 120));

        rangerMerah.tampilkanStatus();
        rangerBiru.tampilkanStatus();

        System.out.println("\n=== PERTARUNGAN DIMULAI ===");
        rangerMerah.serang(rangerBiru);
        rangerBiru.serang(rangerMerah);
    }
}
