package TP7;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        boolean running = true;

        while (running) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih: ");

            int pilih = -1;
            try {
                pilih = sc.nextInt();
                sc.nextLine(); // consume newline
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid, silakan masukkan angka.");
                sc.nextLine(); // consume invalid input
                continue;
            }

            switch (pilih) {
                case 1:
                    System.out.println("Tambah Item:");
                    System.out.println("a. Buku");
                    System.out.println("b. DVD");
                    System.out.print("Pilih jenis item (a/b): ");
                    String jenis = sc.nextLine().trim().toLowerCase();

                    try {
                        if (jenis.equals("a")) {
                            System.out.print("Judul buku: ");
                            String judul = sc.nextLine();
                            System.out.print("ID item: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Nama penulis: ");
                            String author = sc.nextLine();
                            Book book = new Book(judul, id, author);
                            String result = library.addItem(book);
                            System.out.println(result);
                        } else if (jenis.equals("b")) {
                            System.out.print("Judul DVD: ");
                            String judul = sc.nextLine();
                            System.out.print("ID item: ");
                            int id = sc.nextInt();
                            System.out.print("Durasi (menit): ");
                            int durasi = sc.nextInt();
                            sc.nextLine();
                            DVD dvd = new DVD(judul, id, durasi);
                            String result = library.addItem(dvd);
                            System.out.println(result);
                        } else {
                            System.out.println("Jenis item tidak dikenal.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid, proses tambah item gagal.");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    System.out.println("Tambah Anggota:");
                    System.out.print("Nama anggota: ");
                    String nama = sc.nextLine();
                    System.out.print("ID anggota: ");
                    try {
                        int idAnggota = sc.nextInt();
                        sc.nextLine();
                        Member member = new Member(nama, idAnggota);
                        String result = library.addMember(member);
                        System.out.println(result);
                    } catch (InputMismatchException e) {
                        System.out.println("Input ID tidak valid.");
                        sc.nextLine();
                    }
                    break;

                case 3:
                    System.out.print("Masukkan ID anggota yang meminjam: ");
                    try {
                        int memberId = sc.nextInt();
                        sc.nextLine();
                        Member member = library.getMembers().stream()
                                .filter(m -> m.getMemberId() == memberId)
                                .findFirst()
                                .orElse(null);
                        if (member == null) {
                            System.out.println("Anggota tidak ditemukan.");
                            break;
                        }

                        System.out.print("ID item yang ingin dipinjam: ");
                        int itemId = sc.nextInt();
                        System.out.print("Berapa hari: ");
                        int days = sc.nextInt();
                        sc.nextLine();

                        LibraryItem item = library.findItemById(itemId);
                        String msg = member.borrow(item, days);
                        System.out.println(msg);
                        library.getLogger().logActivity(item.getTitle() + " dipinjam oleh " + member.getName());
                    } catch (NoSuchElementException e) {
                        System.out.println("Item tidak ditemukan.");
                    } catch (IllegalStateException | IllegalArgumentException e) {
                        System.out.println("Gagal: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ID anggota yang mengembalikan: ");
                    try {
                        int memberId = sc.nextInt();
                        sc.nextLine();
                        Member member = library.getMembers().stream()
                                .filter(m -> m.getMemberId() == memberId)
                                .findFirst()
                                .orElse(null);
                        if (member == null) {
                            System.out.println("Anggota tidak ditemukan.");
                            break;
                        }

                        System.out.print("ID item yang dikembalikan: ");
                        int retId = sc.nextInt();
                        System.out.print("Berapa hari keterlambatan: ");
                        int late = sc.nextInt();
                        sc.nextLine();

                        LibraryItem item = library.findItemById(retId);
                        String msg = member.returnItem(item, late);
                        System.out.println(msg);
                        library.getLogger().logActivity(item.getTitle() + " dikembalikan oleh " + member.getName());
                    } catch (NoSuchElementException e) {
                        System.out.println("Item tidak ditemukan.");
                    }
                    break;

                case 5:
                    System.out.println("Status Perpustakaan:");
                    System.out.println(library.getLibraryStatus());
                    break;

                case 6:
                    System.out.println("Log Aktivitas:");
                    System.out.println(library.getAllLogs());
                    break;

                case 7:
                    System.out.print("Masukkan ID anggota: ");
                    try {
                        int memberId = sc.nextInt();
                        sc.nextLine();
                        Member member = library.getMembers().stream()
                                .filter(m -> m.getMemberId() == memberId)
                                .findFirst()
                                .orElse(null);
                        if (member == null) {
                            System.out.println("Anggota tidak ditemukan.");
                            break;
                        }
                        System.out.println("Item yang dipinjam oleh " + member.getName() + ":");
                        member.getBorrowedItems();
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid.");
                        sc.nextLine();
                    }
                    break;

                case 8:
                    running = false;
                    System.out.println("Keluar dari sistem. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
        sc.close();
    }
}
