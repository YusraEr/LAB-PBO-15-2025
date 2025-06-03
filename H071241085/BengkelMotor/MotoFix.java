package BengkelMotor;

import java.util.ArrayList;

public class MotoFix {
    private String namaBengkel;
    private String alamatBengkel;
    private ArrayList<Montir> daftarMontir;
    private ArrayList<Customer> daftarCustomer;
    private ArrayList<Customer> antrianPerbaikan;

    public MotoFix() {
        this.daftarMontir = new ArrayList<>();
        this.daftarCustomer = new ArrayList<>();
        this.antrianPerbaikan = new ArrayList<>();
    }

    public MotoFix(String namaBengkel, String alamatBengkel) {
        this.namaBengkel = namaBengkel;
        this.alamatBengkel = alamatBengkel;
        this.daftarMontir = new ArrayList<>();
        this.daftarCustomer = new ArrayList<>();
        this.antrianPerbaikan = new ArrayList<>();
    }

    // getter
    public String getNamaBengkel(){return namaBengkel;}
    public String getAlamatBengkel(){return alamatBengkel;}

    // method yang menambah Montir
    public void tambahMontir(Montir montir){
        daftarMontir.add(montir);
        System.out.println("montir " + montir.getNamaMontir() +
        " (spesialis: " + montir.getSpesialisasi().getNama() +
        ") telah ditambahkan" );
    }

    // method yang menambah customer
    public void tambahCustomer(Customer customer){
        daftarCustomer.add(customer);
        antrianPerbaikan.add(customer);
        System.out.println("customer " + customer.getNamaCustomer() +
        " dengan kerusakan " + customer.getJenisKerusakan().getNama() +
        " telah ditambahkan ke antrian");
    }

    // method antrian motor (yang menangani perbaikan motor)
    public void prosesAntrianPerbaikan(){
        System.out.println("\nMemproses antrian perbaikan . . .");
        for (Customer customer : new ArrayList<>(antrianPerbaikan)){
            boolean ditemukanMontir = false;

            for (Montir montir : daftarMontir){
                if (montir.getSpesialisasi() == customer.getJenisKerusakan() &&
                    montir.getJamKerjaTersisa() >= customer.getDurasiPengerjaan()){

                        if (montir.tambahPekerjaan(customer)){
                            System.out.println("motor " + customer.getNamaCustomer() + 
                            " (" + customer.getMerkMotor() + ")" + 
                            " dengan kerusakan " + customer.getJenisKerusakan().getNama() +
                            " sedang dikerjakan oleh " + montir.getNamaMontir() + 
                            " (Biaya: Rp " + customer.getJenisKerusakan().getHargaPerbaikan() + ")" );
                            antrianPerbaikan.remove(customer);
                            ditemukanMontir = true;
                            break;
                        }
                    }
            }

            if (!ditemukanMontir){
                System.out.println("belum ada montir yang tersedia untuk menangani motor " + 
                customer.getNamaCustomer() + " (" + customer.getJenisKerusakan().getNama() + ")" );
            }
        }
    }

    // method yang menampilkan status bengkel
    public void tampilkanStatusBengkel(){
        System.out.println("\n=== status bengkel " + namaBengkel + " ===");
        System.out.println("alamat: " + alamatBengkel);
        System.out.println("\njumlah montir: " + daftarMontir.size());
        System.out.println("jumlah customer: " + daftarCustomer.size());
        System.out.println("antrian perbaikan: " + antrianPerbaikan.size());

        System.out.println("\ndaftar pekerja:");
        for (Montir montir : daftarMontir){
            montir.tampilkanDetailMontir();
        }
    }

    // method yang menampilkan laporan gaji montir
    public void tampilkanLaporanGaji(){
        System.out.println("\n=== laporan gaji montir ===");
        System.out.println("bengkel: " + namaBengkel);
        System.out.println("total montir: " + daftarMontir.size());
        System.out.println("---------------------------");

        for (Montir montir : daftarMontir){
            montir.tampilkanSlipGaji();
            System.out.println("--------------------------");
        }
    }

    public static void main(String[] args) {
        // meng-inisialisasi begnkel
        MotoFix bengkel01 = new MotoFix("MotoFix Resing", "jl. jalan No.11");

        // kita tambahkan montir ke dalam bengkel
        bengkel01.tambahMontir(new Montir("Uding", "Ban", 8));
        bengkel01.tambahMontir(new Montir("Daeng", "Mesin", 12));
        bengkel01.tambahMontir(new Montir("Alexander", "Bodi", 9));
        
        bengkel01.tambahCustomer(new Customer("ucup", "DD 7075", "Ban", "enmek", 1, false));
        bengkel01.tambahCustomer(new Customer("cecep", "DD 4577", "Mesin", "pario", 4, false));
        bengkel01.tambahCustomer(new Customer("hans", "DP 1234", "Bodi", "peceek", 5, false));

        // untuk memproses antrian, digunakan fungsi ini
        bengkel01.prosesAntrianPerbaikan();

        // menampilkan status bengkel
        bengkel01.tampilkanStatusBengkel();

        // menampilkan laporan gaji para montir
        bengkel01.tampilkanLaporanGaji();
    }
}
