package BengkelMotor;

import java.util.ArrayList;

public class Montir {
    private String namaMontir;
    private JenisKerusakan spesialisasi;
    private int jamKerja;
    private int jamKerjaTerpakai;
    private ArrayList<Customer> motorDikerjakan;
    private double totalGaji;

    public Montir(String namaMontir, String skillMontir, int jamKerja) {
        this.namaMontir = namaMontir;
        this.spesialisasi = JenisKerusakan.dariString(skillMontir);
        this.jamKerja = jamKerja;
        this.jamKerjaTerpakai = 0;
        this.motorDikerjakan = new ArrayList<>();
        this.totalGaji = 0;
    }

    // getter
    public String getNamaMontir(){return namaMontir;}
    public JenisKerusakan getSpesialisasi(){return spesialisasi;}
    public int getJamKerja(){return jamKerja;}
    public ArrayList<Customer> getMotorDikerjakan(){return motorDikerjakan;}
    public int getJamKerjaTerpakai(){return jamKerjaTerpakai;}
    public int getJamKerjaTersisa(){return jamKerja - jamKerjaTerpakai;}
    public double getTotalGaji(){return totalGaji;}

    // method untuk menambahkan tugas atau pekerjaan montir
    public boolean tambahPekerjaan(Customer customer){
        if (customer.getJenisKerusakan() == this.spesialisasi && jamKerjaTerpakai + customer.getDurasiPengerjaan() <= jamKerja){
            motorDikerjakan.add(customer);
            jamKerjaTerpakai += customer.getDurasiPengerjaan();
            totalGaji += customer.getJenisKerusakan().getHargaPerbaikan();
            customer.setMontirYangMenangani(this);
            return true;
        }
        return false;
    }

    //  method untuk menyelesaikan pekerjaan para montir
    public void selesaikanPekerjaan(Customer customer){
        if (motorDikerjakan.contains(customer)){
            customer.setSudahDiperbaiki(true);
        }
    }

    public void tampilkanDetailMontir(){
        System.out.println("=== Detail Montir ===");
        System.out.println("nama: " + namaMontir);
        System.out.println("spesialisasi: " + spesialisasi);
        System.out.println("jam kerja/hari: " + jamKerja + " jam");
        System.out.println("total pendapatan: Rp " + totalGaji);
        System.out.println("motor yang dikerjakan: ");
        for (Customer customer : motorDikerjakan){
            System.out.println("- " + customer.getNamaCustomer() +
            " (" + customer.getMerkMotor() + ")" +
            " - " + customer.getJenisKerusakan().getNama() +
            " - Rp " + customer.getJenisKerusakan().getHargaPerbaikan() +
            " - status: " + (customer.isSudahDiperbaiki() ? "selesai" : "dalam proses") );
        }
    }

    public void tampilkanSlipGaji(){
        System.out.println("=== slip gaji ===");
        System.out.println("nama pekerja: " + namaMontir);
        System.out.println("spesialisasi: " + spesialisasi.getNama());
        System.out.println("total motor diperbaiki: " + motorDikerjakan.size());
        System.out.println("total jam kerja: " + jamKerjaTerpakai + "/" + jamKerja + " jam");
        System.out.println("total gaji: Rp " + totalGaji);
        System.out.println("detail perbaikan: ");
        for (Customer customer : motorDikerjakan){
            System.out.println("- " + customer.getNamaCustomer() +
            " (" + customer.getMerkMotor() + ")" +
            " - " + customer.getJenisKerusakan().getNama() +
            " - Rp " + customer.getJenisKerusakan().getHargaPerbaikan() );
        }
    }
}
