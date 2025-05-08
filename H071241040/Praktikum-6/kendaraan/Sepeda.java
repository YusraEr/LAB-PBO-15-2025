package kendaraan;
import java.util.Date;

public class Sepeda extends AbstrakKendaraan implements IBergerak, IServiceable {
    String jenisSepeda;
    int jumlahGear;
    int ukuranRoda;
    double Kecepatan;
    public Sepeda(String merek, String model){
        super.AbstrakKendaraan(merek, model);
    }
    public String getJenisSepeda() {
        return jenisSepeda;
    }
    public void setJenisSepeda(String jenisSepeda) {
        this.jenisSepeda = jenisSepeda;
    }
    public int getJumlahGear() {
        return jumlahGear;
    }
    public void setJumlahGear(int jumlahGear) {
        this.jumlahGear = jumlahGear;
    }
    public int getUkuranRoda() {
        return ukuranRoda;
    }
    public void setUkuranRoda(int ukuranRoda) {
        this.ukuranRoda = ukuranRoda;
    }
    @Override
     public double hitungPajak(){
        if (ukuranRoda <= 20) {
            return 20000 * ukuranRoda;
        } else if (ukuranRoda > 20 && ukuranRoda <= 26) {
            return 30000 * ukuranRoda;
        } else {
            return 40000 * ukuranRoda;
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
}

