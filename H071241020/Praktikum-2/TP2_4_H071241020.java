package TP_2;

class Alamat {
    public String jalan;
    public String kota;

    public String getAlamatLengkap() {
        return jalan + ", " + kota;
    }
}

class Mahasiswa {
    public Alamat alamat;
    public String nama;
    public String nim;

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getAlamat() {
        return alamat.getAlamatLengkap();
    }
}

public class TP2_4_H071241020 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Tamalanrea Indah";
        alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Farhan";
        mahasiswa.nim = "H071241020";

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}
