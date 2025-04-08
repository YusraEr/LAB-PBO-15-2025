class Alamat {
    String jalan, kota;

    public String setAlamat() {
        return jalan + ", " + kota;
    }
}

class Mahasiswa {
    String nama, nim;
    Alamat alamat = new Alamat();

    public String getNama() {
        return nama;
    }
    public String getNim() {
        return nim;
    }
    public String getAlamat() {
        return alamat.setAlamat();
    }
}

public class noo4 {
    public static void main(String[] args) {
        // Alamat alamat = new Alamat();
        // alamat.jalan = "Tamalanrea Indah";
        // alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.nama = "Alan";
        mahasiswa.nim = "H071241040";
        // mahasiswa.alamat = alamat;
        mahasiswa.alamat.jalan = "Tamalanrea";
        mahasiswa.alamat.kota = "Mks";


        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("NIM: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}
