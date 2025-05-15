package TP6;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus("Toyota", "Fuso");
        bus.setKapasitasPenumpang(100);
        bus.setTahunProduksi(2021);
        bus.getMerek();
        bus.setKecepatan(100);
        bus.setWarna("ungu");
        bus.getKecepatan();
        bus.getTipeKendaraan();
        System.out.println(bus.getModel() + "yang diproduksi pada tahun : " + bus.getTahunProduksi());
        System.out.println(bus.merek + " memiliki pajak: " + bus.hitungPajak());
        System.out.println(bus.mulai());
        System.out.println("bus berjalan dengan kecepatan " + bus.getKecepatan());
        System.out.println(bus.berhenti());
    }
    

}
