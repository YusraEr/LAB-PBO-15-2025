public abstract class Kendaraan {
    protected String id;
    protected String merk;
    protected String model;
    protected int tahunProduksi;
    protected String warna;
    protected double kecepatan; 
    protected double hargaServis;
    protected boolean kondisi;
    protected String tipeKendaraan;

    public Kendaraan(String merk, String model) {
        this.merk = merk;
        this.model = model;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getId() {
        return this.id;
    }

    public String getWarna() {
        return this.warna;
    }

    public double getKecepatan() {
        return this.kecepatan;
    }

    public void setKecepatan(Double kecepatan) {
        this.kecepatan = kecepatan;
    }

    public abstract double hitungPajak();
    public abstract String getTipeKendaraan();
}
