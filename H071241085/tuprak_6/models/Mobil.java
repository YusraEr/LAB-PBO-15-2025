package tuprak_6.models;

import java.util.Calendar;
import java.util.Date;

public class Mobil extends Kendaraan implements IBergerak,IServiceable{
    
    protected double kecepatan = 0.0;
    protected int jumlahPintu;
    protected double kapasitasMesin;
    protected int jumlahKursi;
    protected String bahanBakar;
    private boolean sedangBerjalan = false;
    private boolean kondisiBaik = true;
    private Date waktuServisTerakhir;
    private int kilometerTerakhir = 0;
    private int kilometerSekarang = 0;

    protected int harga, tahunBeli;


    public Mobil(String merek, String model, int kilometerAwal, String tipeKendaraan){
        super(merek, model);
        this.kilometerSekarang = kilometerAwal;
        waktuServisTerakhir = new Date();
        this.tipeKendaraan = tipeKendaraan;
    }

    public int getJumlahPintu(){return jumlahPintu;}
    public void setJumlahPintu(int jumlahPintu){
        this.jumlahPintu = jumlahPintu;
    }

    public double getKapasitasMesin(){return kapasitasMesin;}
    public void setKapasitasMesin(double kapasitasMesin){
        this.kapasitasMesin = kapasitasMesin;
    }

    public int getJumlahKursi(){return jumlahKursi;}
    public void setJumlahKursi(int jumlahKursi){
        this.jumlahKursi = jumlahKursi;
    }

    public String getBahanBakar(){return bahanBakar;}
    public void setBahanBakar(String bahanBakar){
        this.bahanBakar = bahanBakar;
    }

    public double hitungPajak(){
        // diasumsikan NJKB = harga kendaraan saat baru
        // NJKB = Nilai Jual Kendaraan Bermotor
        double njkb = this.harga;

        // menghitung usia kendaraan = tahun sekarang - tahun dibeli
        int tahunSekarang = java.time.Year.now().getValue();
        int usiaKendaraan = tahunSekarang - this.tahunBeli;

        // menghitung penyusutan NJKB
        // 10% per tahunnya (maksimal 10 tahun)
        for(int i = 0; i < usiaKendaraan && i < 10; i++){
            njkb *= 0.9; // mengurangi 10% setiap tahun
        } 

        // menghitung PKN (1,5% untuk mobil kecil, 2% untuk mobil besar)
        // PKB = Pajak Kendaraan Bermotor
        double tarifPkb = (this.kapasitasMesin <= 1_500) ? 0.015 : 0.02;
        double pkb = njkb * tarifPkb;

        // SWDKLLJ = Sumbangan Wajib Dana Kecelakaan Lalu Lintas Jalan 
        // mobil pribadi = Rp 143.000
        double swdkllj = 143_000;

        // total pajak = PKB + SWDKLLJ
        return pkb + swdkllj;
    }

    @Override
    public String getTipeKendaraan(){
        return this.tipeKendaraan;
    }

    @Override
    public boolean mulai(){
        if (!sedangBerjalan){
            sedangBerjalan = true;
            kecepatan = 15.0; // kecepatan awal
            System.out.println("Mobil mulai bergerak");
            return true;
        }
        System.out.println("Mobil sudah berjalan");
        return false;
    }

    @Override
    public boolean berhenti(){
        if (sedangBerjalan){
            sedangBerjalan = false;
            kecepatan = 0.0;
            System.out.println("Mobil berhenti");
            return true;
        }
        System.out.println("Mobil sudah berhenti");
        return false;
    }

    @Override 
    public double getKecepatan(){return this.kecepatan;}

    @Override
    public void setKecepatan(double kecepatan){
        if(sedangBerjalan){
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan diubah menjadi " + kecepatan + " km/jam");
        }else{
            System.out.println("Mobil belum mulai berjalan, tidak bisa mengubah kecepatan");
        }
    }

    @Override
    public boolean periksaKondisi(){
        int jarakTempuh = kilometerSekarang - kilometerTerakhir;
        if (jarakTempuh >= 10_000){
            kondisiBaik = false;
        }else{
            kondisiBaik = true;
        }
        return kondisiBaik;
    }

    @Override
    public void lakukanServis(){
        if (!periksaKondisi()){
            kilometerTerakhir = kilometerSekarang;
            waktuServisTerakhir = new Date();
            kondisiBaik = true;
            System.out.println("servis telah dilakukan");
        }else{
            System.out.println("kondisi masih baik. tidak perlu servis");
        }
    }

    @Override
    public Date getWaktuServisBerikutnya(){
        Calendar kalender = Calendar.getInstance();
        kalender.setTime(waktuServisTerakhir);
        kalender.add(Calendar.MONTH, 6);
        return kalender.getTime();
    }

    @Override
    public double hitungBiayaServis(){
        if (!kondisiBaik){
            return 750_000.0;
        }
        return 0.0;
    }

    public void updateKilometer(int kilometerBaru){
        this.kilometerSekarang = kilometerBaru;
    }

}
