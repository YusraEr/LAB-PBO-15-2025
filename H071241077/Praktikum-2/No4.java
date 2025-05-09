class Alamat {
    String jalan;
    String kota;

   
    public String getAlamat() {
        return jalan + ", " + kota;
    }
}

class Mahasiswa {
    String nama;
    String nim;
    Alamat alamat = new Alamat(); 

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getAlamat() {
        return alamat.getAlamat();
    }
}

public class No4 {
    public static void main(String[] args) {
        // Alamat alamat = new Alamat();
        // alamat.jalan = "BTP";
        // alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        // mahasiswa.alamat = alamat;
        mahasiswa.alamat.jalan = "BTP";
        mahasiswa.alamat.kota = "Makassar";
        mahasiswa.nama = "Diesty Mendila";
        mahasiswa.nim = "H071241077";

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}