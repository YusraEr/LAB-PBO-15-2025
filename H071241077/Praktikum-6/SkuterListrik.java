public class SkuterListrik extends Kendaraan implements IBergerak {
    private double kapasitasMuatan;
    private double kecepatan;

    public SkuterListrik(String merek, String model) {
        super(merek, model);
    }

    public double getKapasitasMuatan() {
        return kapasitasMuatan;
    }

    public void setKapasitasMuatan(double kapasitas) {
        this.kapasitasMuatan = kapasitas;
    }

    @Override
    public boolean mulai() {
        System.out.println("Skuter listrik mulai berjalan.");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Skuter listrik berhenti.");
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    @Override
    public double hitungPajak() {
        return kapasitasMuatan * 0;
    }
}
