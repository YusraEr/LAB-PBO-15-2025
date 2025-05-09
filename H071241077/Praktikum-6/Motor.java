import java.util.Date;

public class Motor extends Kendaraan implements IBergerak, IServicable {
    private String jenisMotor;
    private double kapasitasTangki;
    private String tipeSuspensi;
    private double kecepatan;

    public Motor(String merek, String model) {
        super(merek, model);
    }

    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenis) {
        this.jenisMotor = jenis;
    }

    public double getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setKapasitasTangki(double kapasitas) {
        this.kapasitasTangki = kapasitas;
    }

    public String getTipeSuspensi() {
        return tipeSuspensi;
    }

    public void setTipeSuspensi(String tipeSuspensi) {
        this.tipeSuspensi = tipeSuspensi;
    }

    @Override
    public double hitungPajak() {
        return kapasitasTangki * 50_000;
    }

    @Override
    public String getTipeKendaraan() {
        return "Motor";
    }

    @Override
    public boolean mulai() {
        System.out.println("Motor dinyalakan.");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Motor dimatikan.");
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

    @Override
    public boolean periksaKondisi() {
        return true;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Motor diservis.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(System.currentTimeMillis() + 15L * 24 * 60 * 60 * 1000); // +15 hari
    }

    @Override
    public double hitungBiayaServis() {
        return 250_000;
    }
}

