package tuprak_6.models;

import java.util.Calendar;
import java.util.Date;

public class Keledai extends Kendaraan implements IBergerak, IServiceable {

    private double kecepatan = 0.0; // kecepatan awal keledai
    private int jumlahMuatan; // tunggang max 1, logistik max 6
    private boolean sedangBerjalan = false;
    
    // atribut servis
    private int jarakTempuh = 0;
    private int batasServis = 500;
    private boolean kondisiBaik = true;
    private Date waktuServisTerakhir;

    public Keledai(String jenisKeledai, String modelKeledai, String warna, String id, int tahunProduksi){
        // misalnya "Keledai tunggang", "Keledai Logistik"
        super(jenisKeledai, modelKeledai);
        this.warna = warna;
        this.id = id;
        this.tahunProduksi = tahunProduksi;
    }

    public String getJenisKeledai(){return merek;}
    public void setJenisKeledai(String jenisKeledai){
        this.merek = jenisKeledai;
    }

    public int getJumlahMuatan(){return jumlahMuatan;}
    public void setJumlahMuatan(int jumlahMuatan){
        this.jumlahMuatan = jumlahMuatan;
    }

    @Override
    public double hitungPajak(){return 0.0;}

    @Override
    public String getTipeKendaraan(){return "Keledai";}

    @Override
    public boolean mulai(){
        if (!sedangBerjalan){
            sedangBerjalan = true;
            kecepatan = 2.0;
            System.out.println("Keledai mulai berjalan");
            return true;
        }
        System.out.println("Keledai Sudah berjalan");
        return false;
    }

    @Override
    public boolean berhenti(){
        if (sedangBerjalan){
            sedangBerjalan = false;
            kecepatan = 0.0;
              // tambah jarak tempuh simulasi setiap kali berhenti
            jarakTempuh += 50; // dimisalkan 50km utk contoh
            System.out.println("Keledai berhenti");
            return true;
        }
        System.out.println("Keledai sudah berhenti");
        return false;
    }

    @Override
    public double getKecepatan(){return this.kecepatan;}

    @Override
    public void setKecepatan(double kecepatan){
        if (sedangBerjalan){
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan diubah menjadi " + kecepatan + " km/jam");
        }else{
            System.out.println("Keledai belum mulai bergerak, tidak dapat mengubah kecepatan.");
        }
    }

    @Override
    public boolean periksaKondisi(){
        if (jarakTempuh >= batasServis){
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
            waktuServisTerakhir = new Date();
            kondisiBaik = true;
        }else{
            System.out.println("Sepeda dalam kondisi baik. tidak perlu servis");
        }
    }

    @Override
    public Date getWaktuServisBerikutnya(){
        Calendar kalender = Calendar.getInstance();
        kalender.setTime(waktuServisTerakhir);
        kalender.add(Calendar.MONTH, 1); // servis tiap 1 bulan
        return kalender.getTime();
    }

    @Override
    public double hitungBiayaServis(){
        if(!kondisiBaik){
            return 70_000.0; // biaya servis jika kondisi buruk
        }
        return 0.0;
    }

}
