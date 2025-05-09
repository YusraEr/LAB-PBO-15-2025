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
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat.jalan = "Fanindi st";
        mahasiswa.alamat.kota = "Manokwari";
        mahasiswa.nama = "Angel";
        mahasiswa.nim = "H071241094";

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}