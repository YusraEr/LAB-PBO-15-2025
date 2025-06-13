// package jeniskendaraan;

abstract class Kendaraan{
    protected String id;
    protected String merk;
    protected String model;
    protected int tahunProduksi;  
    protected String warna;
    protected double kecepatan;

    
    public Kendaraan(String merk, String model){
        this.merk = merk;
        this.model = model;
    }
    
    public String getId() {
        return id;
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

    public double getKecepatan() {
        return kecepatan;
    }
    
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    public abstract double hitungPajak();

    public abstract String getTipeKendaraan();
}    

