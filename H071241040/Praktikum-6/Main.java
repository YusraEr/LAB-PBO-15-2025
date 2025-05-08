
import kendaraan.MotorGP;
import kendaraan.Motor;
public class Main {
    public static void main(String[] args) {
      
        MotorGP motorg = new MotorGP("Yamaha", "1000cc");
        motorg.setCCMesin(1000);
        motorg.setbesarBan(10);
        motorg.setJumlahGear(5);

        System.out.println(motorg.getbesarBan());
        System.out.println(motorg.getJumlahGear());
        System.out.println(motorg.getCCMesin());
        System.out.println(motorg.hitungPajak());
        System.out.println(motorg.getTipeKendaraan());


        Motor motor = new Motor("Yamaha", "NMAX");
        motor.setJenisMotor("Motor Balap");
        motor.setKapasitasTangki(24);
        System.out.println(motor.hitungPajak());
        motor.setKecepatan(200);
        motor.lakukanServis();
        System.out.println(motor.getWaktuServisBerikutnya());
        System.out.println(motor.hitungBiayaServis());
        System.out.println(motor.getJenisMotor());
        System.out.println(motor.getKapasitasTangki());
    }
}
