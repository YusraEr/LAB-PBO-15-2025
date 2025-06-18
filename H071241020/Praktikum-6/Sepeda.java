package TP6;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda;
    private double kecepatan;

    public Sepeda(String merek, String model) {
        super(merek, model);
    }

    public String getJenisSepeda() { return jenisSepeda; }
    public void setJenisSepeda(String jenis) { this.jenisSepeda = jenis; }

    public int getJumlahGear() { return jumlahGear; }
    public void setJumlahGear(int jumlah) { this.jumlahGear = jumlah; }

    public int getUkuranRoda() { return ukuranRoda; }
    public void setUkuranRoda(int ukuran) { this.ukuranRoda = ukuran; }

    @Override
    public double hitungPajak() { return 0; }

    @Override
    public String getTipeKendaraan() { return "Sepeda"; }

    @Override
    public boolean mulai() { kecepatan = 2; return true; }

    @Override
    public boolean berhenti() { kecepatan = 0; return true; }

    @Override
    public double getKecepatan() { return kecepatan; }

    @Override
    public void setKecepatan(double kecepatan) { this.kecepatan = kecepatan; }

    @Override
    public boolean periksaKondisi() { return true; }

    @Override
    public void lakukanServis() { System.out.println("Servis sepeda dilakukan."); }

    @Override
    public java.util.Date getWaktuServisBerikutnya() {
        return new java.util.Date(System.currentTimeMillis() + 2592000000L);
    }

    @Override
    public double hitungBiayaServis() { return 100000; }
}
