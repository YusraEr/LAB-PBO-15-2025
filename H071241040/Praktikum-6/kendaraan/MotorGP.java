package kendaraan;

public class MotorGP extends AbstrakKendaraan implements IBergerak {
    int CCMesin;
    int besarBan;
    int jumlahGear;
    double Kecepatan;
public MotorGP(String merek, String model) {
        super.AbstrakKendaraan(merek, model);
    }
    public int getCCMesin() {
        return CCMesin;
    }
    public void setCCMesin(int CCMesin) {
        this.CCMesin = CCMesin;
    }
    public int getbesarBan() {
        return besarBan;
    }
    public void setbesarBan(int besarBan) {
        this.besarBan = besarBan;
    }
    public int getJumlahGear() {
        return jumlahGear;
    }
    public void setJumlahGear(int jumlahGear) {
        this.jumlahGear = jumlahGear;
    }
    @Override
    public double hitungPajak(){
        if (CCMesin <= 1000) {
            return 0.02 * CCMesin;
        } else if (CCMesin > 1000 && CCMesin <= 5000) {
            return 0.03 * CCMesin;
        } else {
            return 0.04 * CCMesin;
        }
    }
    @Override
    public String getTipeKendaraan(){
        return "MotorGP";
    }
    @Override
    public boolean mulai(){
        return true;
    }
    @Override
    public boolean berhenti(){
        return true;
    }
    @Override
    public double getKecepatan(){
        return 0;
    }
    @Override
    public void setKecepatan(double Kecepatan){
        this.Kecepatan = Kecepatan;
    }
}
