import java.util.Scanner;

public class Maain{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        dosen dosen = new dosen();
        mahasiswa mahasis1 = new mahasiswa();
        mahasiswa mahasis2 = new mahasiswa();

        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Input data mahasiswa 1");
            System.out.println("2. Input data mahasiswa 2");
            System.out.println("3. Tampilkan info kedua mahasiswa");
            System.out.println("4. Bandingkan nilai mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int menu = input.nextInt();
            input.nextLine();

            if (menu == 1) {
                System.out.print("Masukkan nama mahasiswa 1: ");
                String nama = input.nextLine();
                System.out.print("Masukkan NIM mahasiswa 1: ");
                String nim = input.nextLine();
                System.out.print("Nilai Tugas: ");
                double tugas = input.nextDouble();
                System.out.print("Nilai Kuis: ");
                double kuis = input.nextDouble();
                System.out.print("Nilai UTS: ");
                double uts = input.nextDouble();
                System.out.print("Nilai UAS: ");
                double uas = input.nextDouble();

                mahasis1 = new mahasiswa(nama, nim);
                dosen.inputNilai(mahasis1, tugas, kuis, uts, uas);
                mahasis1.setSukses();

            } else if (menu == 2) {
                System.out.print("Masukkan nama mahasiswa 2: ");
                String nama = input.nextLine();
                System.out.print("Masukkan NIM mahasiswa 2: ");
                String nim = input.nextLine();
                System.out.print("Nilai Tugas: ");
                double tugas = input.nextDouble();
                System.out.print("Nilai Kuis: ");
                double kuis = input.nextDouble();
                System.out.print("Nilai UTS: ");
                double uts = input.nextDouble();
                System.out.print("Nilai UAS: ");
                double uas = input.nextDouble();

                mahasis2 = new mahasiswa(nama, nim);
                dosen.inputNilai(mahasis2, tugas, kuis, uts, uas);
                mahasis2.setSukses();

            } else if (menu == 3) {
                if (mahasis1.getSukses()) mahasis1.tampilkanInfo();
                if (mahasis2.getSukses()) mahasis2.tampilkanInfo();

            } else if (menu == 4) {
                if (mahasis1.getSukses() && mahasis2.getSukses()) {
                    mahasis1.bandingkanNilai(mahasis2);
                } else {
                    System.out.println("Data kedua mahasiswa belum lengkap!");
                }

            } else if (menu == 5) {
                System.out.println("Terima kasih!");
                break;

            } else {
                System.out.println("Menu tidak valid.");
            }
        }

        input.close();
    }
}

