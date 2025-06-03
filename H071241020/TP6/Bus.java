package TP6;

public class Bus extends Kendaraan implements IBergerak{
    private int kapasitasPenumpang;
    private double kecepatan;

    public Bus(String merek, String model) {
        super(merek, model);
    }

    public int getKapasitasPenumpang() {
        return kapasitasPenumpang;
    }

    public void setKapasitasPenumpang(int kapasitasPenumpang) {
        this.kapasitasPenumpang = kapasitasPenumpang;
    }

    @Override
    public double hitungPajak() {
        return kapasitasPenumpang * 100;
    }

    @Override
    public String getTipeKendaraan() {
        return "Bus";
    }

    @Override
    public boolean mulai() {
        System.out.println("Bus mulai bergerak.");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Bus berhenti.");
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }
}

