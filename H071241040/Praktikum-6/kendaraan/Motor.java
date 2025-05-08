package kendaraan;

import java.util.Date;

public class Motor extends AbstrakKendaraan implements IBergerak, IServiceable {
    String jenisMotor;
    double kapasitasTangki;
    String tipeSuspensi;
    double Kecepatan;
    public Motor(String merek, String model){
        super.AbstrakKendaraan(merek, model);
    }
    public String getJenisMotor() {
        return jenisMotor;
    }
    public void setJenisMotor(String jenisMotor) {
        this.jenisMotor = jenisMotor;
    }
    public double getKapasitasTangki() {
        return kapasitasTangki;
    }
    public void setKapasitasTangki(double kapasitasTangki) {
        this.kapasitasTangki = kapasitasTangki;
    }
    public String getTipeSuspensi() {
        return tipeSuspensi;
    }
    @Override
     public double hitungPajak(){
        if (kapasitasTangki <= 8) {
            return 100000 * kapasitasTangki;
        } else if (kapasitasTangki > 8 && kapasitasTangki <= 14) {
            return 120000 * kapasitasTangki;
        } else {
            return 300000 * kapasitasTangki;
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
        return null;
    }
}
