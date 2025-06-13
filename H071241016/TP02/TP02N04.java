// Kelas Alamat
class Alamat {
    String jalan;
    String kota;

    // Metode untuk mendapatkan alamat dalam satu string
    public String getAlamat() {
        return jalan + ", " + kota;
    }
}

// Kelas Mahasiswa
class Mahasiswa {
    String nama;
    String nim;
    Alamat alamat = new Alamat();

    // Metode untuk mendapatkan nama
    public String getNama() {
        return nama;
    }

    // Metode untuk mendapatkan NIM
    public String getNim() {
        return nim;
    }

    // Metode untuk mendapatkan alamat
    public String getAlamat() {
        return alamat.getAlamat();
    }
}

// Kelas Main untuk menjalankan program
public class TP02N04 {
    public static void main(String[] args) {
        Mahasiswa mahasiswa = new Mahasiswa();
        // Alamat alamat = new Alamat();
        mahasiswa.nama = "Aqiila Zaizaafun";
        mahasiswa.nim = "H071231016";
        mahasiswa.alamat.jalan = "Tamalanrea Indah";
        mahasiswa.alamat.kota = "Makassar";
        // Menampilkan output
        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}