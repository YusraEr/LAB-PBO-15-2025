package TP_2;


public class TP2_2_H071241020 {
    private String id;
    private String nama;
    private int stok;
    private double harga;

    public TP2_2_H071241020(String id, String nama, int stok, double harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public void cekDataProduk() {
        System.out.println("ID Produk: " + id);
        System.out.println("Nama Produk: " + nama);
        System.out.println("Stok Produk: " + stok);
        System.out.println("Harga Produk: Rp" + harga);
    }

    public void cekStok() {
        if (stok > 0) {
            System.out.println("Produk " + nama + " tersedia di stok.");
        } else {
            System.out.println("Produk " + nama + " tidak tersedia di stok.");
        }
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public double getHarga() {
        return harga;
    }

    public static void main(String[] args) {
        TP2_2_H071241020 produk1 = new TP2_2_H071241020("P001", "Laptop Asus", 10, 8999000);
        
        produk1.cekDataProduk();
        System.out.println(); 
        
        produk1.cekStok();
    }
}