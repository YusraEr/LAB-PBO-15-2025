package tuprak_6.models;

public abstract class Kendaraan {
    protected String id, merek, model, warna;
    protected int tahunProduksi;
    protected String tipeKendaraan;

    public Kendaraan(String merek, String model){
        this.merek = merek;
        this.model = model;
    }

    public String getId(){return id;}
    public String getMerek(){return merek;}
    public String getModel(){return model;}

    public int getTahunProduksi(){return tahunProduksi;}
    public void setTahunProduksi(int tahunProduksi){
        this.tahunProduksi = tahunProduksi;
    }

    public String getWarna(){return warna;}
    public void setWarna(String warna){
        this.warna = warna;
    }

    public abstract double hitungPajak();

    public abstract String getTipeKendaraan();
}
