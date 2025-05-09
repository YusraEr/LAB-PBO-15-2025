public class gradeReport {
    double tugas;
    double kuis;
    double uts;
    double uas;

    public void setNilai(double tugas, double kuis, double uts, double uas) {
        this.tugas = tugas;
        this.kuis = kuis;
        this.uts = uts;
        this.uas = uas;
    }

    public double getNilai() {
        return (tugas * 0.2 + kuis * 0.2 + uts * 0.25 + uas * 0.35);
    }

    public String getKelulusan() {
        return getNilai() >= 65 ? "LULUS" : "TIDAK LULUS";
    }

    public void getRincian() {
        System.out.println("Rincian Nilai:");
        System.out.println("Tugas: " + tugas);
        System.out.println("Kuis: " + kuis);
        System.out.println("UTS: " + uts);
        System.out.println("UAS: " + uas);
    }
}
