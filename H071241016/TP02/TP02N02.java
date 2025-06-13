public class TP02N02 {
    String id; // ID produk contohnya p001
    String nama; // Nama produk contohnya blush on
    int stok; // Jumlah stok produk
    double harga; // Harga produk

    // Konstruktor untuk membuat objek TP02N02 baru
    public TP02N02(String id, String nama, int stok, double harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    // Metode untuk mendapatkan ID produk
    public String getId() {
        return id;
    }

    // Metode untuk mendapatkan nama produk
    public String getNama() {
        return nama;
    }

    // Metode untuk mendapatkan stok produk
    public int getStok() {
        return stok;
    }

    // Metode untuk mendapatkan harga produk
    public double getHarga() {
        return harga;
    }

    // Method untuk menampilkan informasi produk
    public void tampilkanInfoProduk() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: " + harga);
    }

    // Method untuk mengecek ketersediaan stok produk
    public void cekKetersediaanStok() {
        if (stok > 0) {
            System.out.println("Stok tersedia.");
        } else {
            System.out.println("Stok habis.");
        }
    }

    // Metode utama (main) untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek TP02N02 baru
        TP02N02 produk1 = new TP02N02("P001", "blush on", 10, 600000);
        produk1.tampilkanInfoProduk();
        produk1.cekKetersediaanStok();
        System.out.println(); // Baris kosong untuk pemisah

        // Membuat objek TP02N02 baru
        TP02N02 produk2 = new TP02N02("P002", "cushion", 0, 175000);
        produk2.tampilkanInfoProduk();
        produk2.cekKetersediaanStok();
    }
}