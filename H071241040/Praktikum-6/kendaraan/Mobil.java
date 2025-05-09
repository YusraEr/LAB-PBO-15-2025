package kendaraan;
import java.util.Date;

public class Mobil extends AbstrakKendaraan implements IBergerak, IServiceable {
    int JumlahPintu;
    double kapasitasMesin;
    int jumlahKursi;
    String bahanBakar;
    double Kecepatan;
    public Mobil(String merek, String model) {
        super.AbstrakKendaraan(merek, model);
    }
    public int getJumlahPintu() {
        return JumlahPintu;
    }
    public void setJumlahPintu(int JumlahPintu) {
        this.JumlahPintu = JumlahPintu;
    }
    public double getKapasitasMesin() {
        return kapasitasMesin;
    }
    public void setKapasitasMesin(double kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
    }
    public int getJumlahKursi() {
        return jumlahKursi;
    }
    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }
    public String getBahanBakar() {
        return bahanBakar;
    }
    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }
    @Override
     public double hitungPajak(){
        if (kapasitasMesin <= 1500) {
            return 1000 * kapasitasMesin;
        } else if (kapasitasMesin > 1500 && kapasitasMesin <= 3000) {
            return 1100 * kapasitasMesin;
        } else {
            return 1200 * kapasitasMesin;
        }
    }
    @Override
    public String getTipeKendaraan(){
        return "Sepeda";
    }
    @Override
    public boolean mulai(){
        return true;
    }
    @Override
    public boolean berhenti(){
        return true;
    }
    @Override
    public double getKecepatan(){
        return Kecepatan;
    }
    @Override
    public void setKecepatan(double Kecepatan){
        this.Kecepatan = Kecepatan;
    }
    @Override
    public boolean periksaKondisi(){
        return true;
    }
    @Override
    public void lakukanServis(){
        System.out.println("Servis sepeda dilakukan.");
    }
    public Date getWaktuServisBerikutnya(){
        Date hariIni = new Date();
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(hariIni);
        cal.add(java.util.Calendar.MONTH, 2); 
        return cal.getTime(); 
    }
    @Override
    public double hitungBiayaServis(){
       return 200.000;
    }
    @Override
    public Date getTanggalServisTerakhir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTanggalServisTerakhir'");
    }
}
