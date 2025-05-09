package kendaraan;

public abstract class AbstrakKendaraan {
    protected String id;
    protected String merek;
    protected String model;
    int tahunProduksi;
    String warna;
    public void AbstrakKendaraan(String merek, String model){
        this.merek = merek;
        this.model = model;
    }
    public String getId() {
        return id;
    }
    public String getMerek() {
        return merek;
    }
    public String getModel() {
        return model;
    }
    public int getTahunProduksi() {
        return tahunProduksi;
    }
    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }
    public String getWarna() {
        return warna;
    }
    public void setWarna(String warna) {
        this.warna = warna;
    }
    public abstract double hitungPajak();
    public abstract String getTipeKendaraan();
}
