import java.util.Calendar;
import java.util.Date;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {

    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;

    public Mobil(String merk, String model) {
        super(merk, model);
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setKapasitasMesin(double kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
    }

    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setKondisi(boolean kondisi) {
        this.kondisi = kondisi;
    }

    public boolean getKondisi() {
        return kondisi;
    }

    @Override
    public boolean mulai() {
        System.out.println("Mobil mulai berjalan.");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Mobil berhenti.");
        return true;
    }

    @Override
    public boolean periksaKondisi() {
        return kondisi;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Servis mobil dilakukan.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 2);
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
        return kapasitasMesin * 50000;
    }

    @Override
    public String getTipeKendaraan() {
        return this.tipeKendaraan;
    }

    public void setTipeKendaraan(String tipeKendaraan){
        this.tipeKendaraan = tipeKendaraan;
    }
}
