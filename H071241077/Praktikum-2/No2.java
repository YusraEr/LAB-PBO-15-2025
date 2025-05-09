public class No2 {
    String id;
    String nama;
    int stok;
    double harga;

    public No2(String id, String nama, int stok, double harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }
 
    public void tampilkanInfoProduk() {
        System.out.println("ID Produk: " + id);
        System.out.println("Nama Produk: " + nama);
        if (stok < 0) {
            System.out.println("Stok tidak tersedia");
        } else {
            System.out.println("Stok: " + stok);
        }

        System.out.println("Harga: Rp" + String.format("%.0f", harga));
    }

    public boolean isTersedia() {
        return stok > 0;
    }

    public static void main(String[] args) {
        No2 produk1 = new No2("P001", "Kaos Kaki", -1 , 10000);
       
        produk1.tampilkanInfoProduk();
        System.out.println("Produk Tersedia di Stok? " + (produk1.isTersedia() ? "Ya" : "Tidak"));
        
    }
}
