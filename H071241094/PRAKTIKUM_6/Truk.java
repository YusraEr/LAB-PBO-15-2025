public class Truk extends Kendaraan implements IBergerak {
    private double kapasitasMuatan; // dalam ton
    private double kecepatan;

    public Truk(String merek, String model) {
        super(merek, model);
    }

    public double getKapasitasMuatan() {
        return kapasitasMuatan;
    }

    public void setKapasitasMuatan(double kapasitasMuatan) {
        this.kapasitasMuatan = kapasitasMuatan;
    }

    public String getTipeKendaraan(){
        return this.tipeKendaraan;
    }

    @Override
    public double getKecepatan() {
        return this.kecepatan;
    }

    @Override
    public void setKecepatan(Double kecepatan) {
        this.kecepatan = kecepatan;
    }

    @Override
    public boolean mulai() {
        System.out.println("Truk mulai berjalan.");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Truk berhenti.");
        return true;
    }

    @Override
    public double hitungPajak() {
        return kapasitasMuatan * 150_000; // pajak per ton
    }
}
