// File: Main.java
import Perpus.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        library library = new library();

        while (true) {
            System.out.println("=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Jenis item (1. Buku, 2. DVD): ");
                    int jenis = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Judul: ");
                    String title = scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if (jenis == 1) {
                        System.out.print("Penulis: ");
                        String author = scanner.nextLine();
                        System.out.println(library.addItem(new Book(title, id, author)));
                        library.getLogger().logActivity("Buku \"" + title + "\" dengan id " + id + " telah ditambahkan.");
                    } else if (jenis == 2) {
                        System.out.print("Durasi (menit): ");
                        int duration = scanner.nextInt();
                        System.out.println(library.addItem(new DVD(title, id, duration)));
                        library.getLogger().logActivity("DVD \"" + title + "\" dengan id " + id + " telah ditambahkan.");
                    }
                    break;

                case 2:
                    System.out.print("Nama Anggota: ");
                    String name = scanner.nextLine();
                    System.out.print("ID Anggota: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        library.findMemberById(memberId);
                        System.out.println("Anggota dengan ID " + memberId + " sudah terdaftar.");
                    } catch (Exception e) {
                        library.addMember(new Member(name, memberId));
                        System.out.println("Anggota berhasil ditambahkan.");
                        library.getLogger().logActivity(name + " dengan ID " + memberId + " telah ditambahkan.");
                    }
                    break;

                case 3:
                    System.out.print("ID Anggota: ");
                    int mid = scanner.nextInt();
                    System.out.print("ID Item: ");
                    int iid = scanner.nextInt();
                    System.out.print("Jumlah hari: ");
                    int days = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Member m = library.findMemberById(mid);
                        LibraryItem item = library.findItemById(iid);
                        System.out.println(m.borrow(item, days));
                        library.getLogger().logActivity("Item \"" + item.title + "\" dipinjam oleh " + m.getName());
                    } catch (Exception e) {
                        System.out.println("Gagal meminjam: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("ID Anggota: ");
                    int memId = scanner.nextInt();
                    System.out.print("ID Item: ");
                    int itemId = scanner.nextInt();
                    System.out.print("Terlambat (hari): ");
                    int late = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Member m = library.findMemberById(memId);
                        LibraryItem item = library.findItemById(itemId);
                        System.out.println(m.returnItem(item, late));
                        library.getLogger().logActivity("Item" + item.getTitle() + " dikembalikan oleh " + m.getName());
                    } catch (Exception e) {
                        System.out.println("Gagal meminjam: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("\nStatus Perpustakaan:\n" + library.getLibraryStatus());
                    break;

                case 6:
                    System.out.println("\nLog Aktivitas:\n" + library.getAllLogs());
                    break;

                case 7:
                    System.out.print("ID Anggota: ");
                    int viewId = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Member anggota = library.findMemberById(viewId);
                        anggota.getBorrowedItems();
                    } catch (Exception e) {
                        System.out.println("Anggota tidak ditemukan");
                    }
                    break;

                case 8:
                    System.out.println("Keluar dari sistem...");
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        }
    }
}

