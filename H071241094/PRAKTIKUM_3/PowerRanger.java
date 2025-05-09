public class PowerRanger {
    public String nama;
    public String warna;
    public int nyawa;
    public Senjata senjata;

    public PowerRanger() {
        this.nama = "Ranger";
        this.warna = "Abu-Abu";
        this.nyawa = 100;
        this.senjata = new Senjata();
    }

    public PowerRanger(String nama, String warna, int nyawa, Senjata senjata) {
        this.nama = nama;
        this.warna = warna;
        this.nyawa = nyawa;
        this.senjata = senjata;
    }

    public void serang(PowerRanger musuh) {
        int nyawaBerkurang = this.senjata.kekuatan;
        musuh.nyawa -= nyawaBerkurang;
        if (musuh.nyawa < 0) {
            musuh.nyawa = 0;
            System.out.println(musuh.nama + " mati");
        }

        System.out.println(this.nama + " (" + this.warna + ") menyerang " + musuh.nama + " dengan " + senjata.nama);
        System.out.println(musuh.nama + " kehilangan " + nyawaBerkurang + " nyawa, Sisa nyawanya " + musuh.nyawa);
    }

    public void tampilkanStatus() {
        System.out.println("Nama: " + nama);
        System.out.println("Warna: " + warna);
        System.out.println("Energi: " + nyawa);
        System.out.println("Senjata: " + senjata.nama + " (Kekuatan: " + senjata.kekuatan + ")");
    }
}
