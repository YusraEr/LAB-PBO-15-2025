// package jeniskendaraan;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi; // Ditambahkan dari kodeku
    private String bahanBakar; // Ditambahkan dari kodeku
    private boolean mulai;
    private boolean berhenti;
    private double  kecepatan;

    public Mobil(String merk, String model) {
        super(merk, model);
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
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
    public boolean mulai() {
        if (!mulai) {
            mulai = true;
            berhenti = false;
            System.out.println("Mobil dinyalakan.");
            return true;
        }
        return false;
    }

    @Override
    public boolean berhenti() {
        if (!berhenti) {
            berhenti = true;
            mulai = false;
            kecepatan = 0;
            System.out.println("Mobil dihentikan.");
            return true;
        }
        return false;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        if (mulai && !berhenti && kecepatan >= 0) {
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan mobil disetel ke " + kecepatan + " km/h.");
        } else {
            System.out.println("Mobil harus dinyalakan terlebih dahulu!");
        }
    }

    @Override
    public boolean periksaKondisi() {
        boolean kondisiBaik = kapasitasMesin > 0 && jumlahPintu > 0;
        System.out.println("Pemeriksaan mobil: " + (kondisiBaik ? "Layak jalan" : "Perlu servis"));
        return kondisiBaik;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Servis mobil: ganti oli, cek rem, cek mesin.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 6); // Servis setiap 6 bulan
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        double biaya = 500000 + (kapasitasMesin * 100000);
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        System.out.println("Biaya servis: " + rupiah.format(biaya));
        return biaya;
    }

    @Override
    public double hitungPajak() {
        double pajak = kapasitasMesin * 500000;
        System.out.println("Pajak mobil: Rp" + pajak);
        return pajak;
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
    }
}