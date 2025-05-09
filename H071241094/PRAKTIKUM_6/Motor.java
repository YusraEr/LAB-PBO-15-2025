import java.util.Calendar;
import java.util.Date;

public class Motor extends Kendaraan implements IBergerak, IServiceable {

    private String jenisMotor;
    private double kapasitasTangki;
    private String tipeSuspensi;

    public Motor(String merk, String model) {
        super(merk, model);
    }

    public void setJenisMotor(String jenisMotor) {
        this.jenisMotor = jenisMotor;
    }

    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setKapasitasTangki(double kapasitasTangki) {
        this.kapasitasTangki = kapasitasTangki;
    }

    public double getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setTipeSuspensi(String tipeSuspensi) {
        this.tipeSuspensi = tipeSuspensi;
    }

    public String getTipeSuspensi() {
        return tipeSuspensi;
    }

    public void setKondisi(boolean kondisi) {
        this.kondisi = kondisi;
    }

    @Override
    public boolean mulai() {
        System.out.println("Motor mulai berjalan.");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Motor berhenti.");
        return true;
    }

    @Override
    public boolean periksaKondisi() {
        return kondisi;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Servis motor dilakukan.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        return hargaServis;
    }

    public void setHargaServis(double hargaServis) {
        this.hargaServis = hargaServis;
    }

    @Override
    public double hitungPajak() {
        return kapasitasTangki * 30000;
    }

    @Override
    public String getTipeKendaraan() {
        return this.tipeKendaraan;
    }

    public void setTipeKendaraan(String tipeKendaraan){
        this.tipeKendaraan = tipeKendaraan;
    }
}
