import java.util.Calendar;
import java.util.Date;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable {

    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda;

    public Sepeda(String merk, String model) {
        super(merk, model);
    }

    public void setJenisSepeda(String jenisSepeda) {
        this.jenisSepeda = jenisSepeda;
    }

    public String getJenisSepeda() {
        return jenisSepeda;
    }

    public void setJumlahGear(int jumlahGear) {
        this.jumlahGear = jumlahGear;
    }

    public int getJumlahGear() {
        return jumlahGear;
    }

    public void setUkuranRoda(int ukuranRoda) {
        this.ukuranRoda = ukuranRoda;
    }

    public int getUkuranRoda() {
        return ukuranRoda;
    }

    public void setKondisi(boolean kondisi) {
        this.kondisi = kondisi;
    }

    @Override
    public boolean mulai() {
        System.out.println("Sepeda mulai dikayuh.");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Sepeda berhenti.");
        return true;
    }

    @Override
    public boolean periksaKondisi() {
        return kondisi;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Servis sepeda dilakukan.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        return hargaServis;
    }

    public void setHargaServis(double hargaServis) {
        this.hargaServis = hargaServis;
    }

    @Override
    public double hitungPajak() {
        return 0; 
    }

    @Override
    public String getTipeKendaraan() {
        return this.tipeKendaraan;
    }

    public void setTipeKendaraan(String tipeKendaraan){
        this.tipeKendaraan = tipeKendaraan;
    }
}
