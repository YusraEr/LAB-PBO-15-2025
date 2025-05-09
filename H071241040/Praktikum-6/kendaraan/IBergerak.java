package kendaraan;


public interface IBergerak {
    boolean mulai();
    boolean berhenti();
    double getKecepatan();
    void setKecepatan(double Kecepatan);
}