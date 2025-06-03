package BengkelMotor;

public class Customer {
    private String namaCustomer;
    private String platMotor;
    private JenisKerusakan jenisKerusakan;
    private String merkMotor;
    private int durasiPengerjaan;
    private boolean sudahDiperbaiki;
    private Montir montirYangMenangani;

    public Customer(String namaCustomer, String platMotor, String kerusakan, String merkMotor,
            int durasiPengerjaan, boolean sudahDiperbaiki) {
        this.namaCustomer = namaCustomer;
        this.platMotor = platMotor;
        this.jenisKerusakan = JenisKerusakan.dariString(kerusakan);
        this.merkMotor = merkMotor;
        this.durasiPengerjaan = durasiPengerjaan;
        this.sudahDiperbaiki = sudahDiperbaiki;
    }

    // getter
    public String getNamaCustomer(){return namaCustomer;}
    public String getPlatMotor(){return platMotor;}
    public JenisKerusakan getJenisKerusakan(){return jenisKerusakan;}
    public String getMerkMotor(){return merkMotor;}
    public int getDurasiPengerjaan(){return durasiPengerjaan;}
    public boolean isSudahDiperbaiki(){return sudahDiperbaiki;}
    public Montir getMontirYangMenangani(){return montirYangMenangani;}

    // setter
    public void setMontirYangMenangani(Montir montir){
        this.montirYangMenangani = montir;
    }

    public void setSudahDiperbaiki(boolean status){
        this.sudahDiperbaiki = status;
    }
    
    public String toString(){
        return "Costumer{" +
                "nama ='" + namaCustomer + '\'' +
                ", plat ='" + platMotor + '\'' +
                ", kerusakan ='" + jenisKerusakan.getNama() + '\'' +
                ", merk ='" + merkMotor + '\'' +
                ", durasi ='" + durasiPengerjaan + " jam" +
                ", biaya =Rp " + jenisKerusakan.getHargaPerbaikan() +
                ", status = " + (sudahDiperbaiki ? "selesai" : "Dalam Antrian") +
                '}';
    }
}
