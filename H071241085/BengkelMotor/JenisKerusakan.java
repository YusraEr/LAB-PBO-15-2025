package BengkelMotor;


public enum JenisKerusakan {
    BAN("Ban", 70_000),
    MESIN("Mesin", 300_000),
    BODI("Bodi", 180_000);

    private final String nama;
    private final int hargaPerbaikan;

    JenisKerusakan(String nama, int hargaPerbaikan){
        this.nama = nama;
        this.hargaPerbaikan = hargaPerbaikan;
    }

    public String getNama(){return nama;}

    public int getHargaPerbaikan(){return hargaPerbaikan;}

    public static JenisKerusakan dariString(String nama){
        for (JenisKerusakan jenis : values()){
            if (jenis.nama.equalsIgnoreCase(nama)){
                return jenis;
            }
        }
        throw new IllegalArgumentException("jenis kerusakan tidak valid: " + nama);
    }
}
