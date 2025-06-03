package tuprak_6.models;

import java.util.Calendar;
import java.util.Date;

public class Sepeda extends Kendaraan implements IBergerak,IServiceable {
    protected String jenisSepeda;
    protected int jumlahGear, ukuranRoda;
    protected double kecepatan;
    private boolean sedangBerjalan = false;

    // atribut servis
    private int jarakTempuh = 0; // satuan kilometer
    private int batasServis = 1_000;
    private boolean kondisiBaik = true;
    private Date waktuServisTErakhir;

    public Sepeda(String merek, String model, String tipeKendaraan){
        super(merek, model);
        this.tipeKendaraan = tipeKendaraan;
        this.waktuServisTErakhir = new Date(); // servis awal dianggap sekarang
    }

    // setter getter khusus sepeda
    public String getJenisSepeda(){return jenisSepeda;}
    public void setJenisSepeda(String jenisSepeda){
        this.jenisSepeda = jenisSepeda;
    }

    public int getJumlahGear(){return jumlahGear;}
    public void setJumlahGear(int jumlahGear){
        this.jumlahGear = jumlahGear;
    }

    public int getUkuranRoda(){return ukuranRoda;}
    public void setUkuranRoda(int ukuranRoda){
        this.ukuranRoda = ukuranRoda;
    }

    // implementasi dari kendaraan (abstrak)
    @Override
    public double hitungPajak(){return 0.0;}

    @Override
    public String getTipeKendaraan(){return "Sepeda";}

    // implementasi dari IBergerak
    @Override
    public boolean mulai(){
        if (!sedangBerjalan){
            sedangBerjalan = true;
            kecepatan = 5.0;
            System.out.println("Sepeda mulai bergerak");
            return true;
        }
        System.out.println("Sepeda sudah berjalan");
        return false;
    }

    @Override
    public boolean berhenti(){
        if (sedangBerjalan){
            sedangBerjalan = false;
            kecepatan = 0.0;
            // tambah jarak tempuh simulasi setiap kali berhenti
            jarakTempuh += 100; // dimisalkan 100km utk contoh
            System.out.println("Sepeda berhenti");
            return true;
        }
        System.out.println("Sepeda sudah berhenti");
        return false;
    }

    @Override 
    public double getKecepatan(){return this.kecepatan;}

    @Override
    public void setKecepatan(double kecepatan){
        if (sedangBerjalan){
            this.kecepatan = kecepatan;
            System.out.println("kecepatan diubah menjadi " + kecepatan + " km/jam");
        }else{
            System.out.println("Sepeda belum mulai bergerak. tidak bisa mengubah kecepatan");
        }
    }

    // implementasi IServiceable
    @Override
    public boolean periksaKondisi(){
        if(jarakTempuh >= batasServis){
            kondisiBaik = false;
        }else{
            kondisiBaik = true;
        }
        return kondisiBaik;
    }

    @Override
    public void lakukanServis(){
        if (!periksaKondisi()){
            System.out.println("Melakukan servis sepeda");
            jarakTempuh = 0;
            waktuServisTErakhir = new Date();
            kondisiBaik = true;
        }else{
            System.out.println("Sepeda dalam kondisi baik. tidak perlu servis");
        }
    }

    @Override
    public Date getWaktuServisBerikutnya(){
        Calendar kalender = Calendar.getInstance();
        kalender.setTime(waktuServisTErakhir);
        kalender.add(Calendar.MONTH, 3); // servis tiap 3 bulan
        return kalender.getTime();
    }

    @Override
    public double hitungBiayaServis(){
        if(!kondisiBaik){
            return 150_000.0; // biaya servis jika kondisi buruk
        }
        return 0.0;
    }
}
