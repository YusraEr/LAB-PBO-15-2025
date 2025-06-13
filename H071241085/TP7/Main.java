package TP7;
import java.util.NoSuchElementException;
import java.util.Scanner;

import TP7.models.Book;
import TP7.models.DVD;
import TP7.models.Library;
import TP7.models.LibraryItem;
import TP7.models.Member;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {
        System.out.println("=== Sistem Manajemen Perpustakaan ===");
        
        boolean exit = false;
        while (!exit) {
            try {
                printMainMenu();
                int choice = getIntInput("Pilih menu: ", 1, 8);
                
                switch (choice) {
                    case 1: addItemMenu(); break;
                    case 2: addMemberMenu(); break;
                    case 3: borrowItemMenu(); break;
                    case 4: returnItemMenu(); break;
                    case 5: viewLibraryStatus(); break;
                    case 6: viewActivityLogs(); break;
                    case 7: viewMemberBorrowedItems(); break;
                    case 8: exit = true; break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Terima kasih telah menggunakan sistem perpustakaan.");
    }

    private static void printMainMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
    }

    private static void addItemMenu() {
        System.out.println("\nTambah Item:");
        System.out.println("1. Buku");
        System.out.println("2. DVD");
        int type = getIntInput("Pilih jenis item: ", 1, 2);
        
        String title = getNonEmptyInput("Masukkan judul: ");
        int itemId = getPositiveIntInput("Masukkan ID item: ");
        
        try {
            LibraryItem item;
            if (type == 1) {
                String author = getNonEmptyInput("Masukkan nama penulis: ");
                item = new Book(title, itemId, author);
            } else {
                int duration = getPositiveIntInput("Masukkan durasi (menit): ");
                item = new DVD(title, itemId, duration);
            }
            
            System.out.println(library.addItem(item));
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal menambahkan item: " + e.getMessage());
        }
    }

    // Helper methods untuk input validation
    private static int getIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = Integer.parseInt(scanner.nextLine());
                if (input < min || input > max) {
                    System.out.printf("Masukkan angka antara %d-%d\n", min, max);
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka");
            }
        }
    }

    private static int getPositiveIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = Integer.parseInt(scanner.nextLine());
                if (input <= 0) {
                    System.out.println("Input harus bilangan positif");
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka");
            }
        }
    }

    private static String getNonEmptyInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input tidak boleh kosong");
        }
    }

    private static void addMemberMenu() {
        System.out.println("\nTambah Anggota:");
        System.out.print("Masukkan nama anggota: ");
        String name = scanner.nextLine();
        
        System.out.print("Masukkan ID anggota: ");
        int memberId;
        try {
            memberId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID harus berupa angka");
            return;
        }
        
        Member member = new Member(name, memberId);
        System.out.println(library.addMember(member));
    }

    private static void borrowItemMenu() {
        System.out.println("\nPinjam Item:");
        
        System.out.print("Masukkan ID anggota: ");
        int memberId;
        try {
            memberId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID harus berupa angka");
            return;
        }
        
        System.out.print("Masukkan ID item: ");
        int itemId;
        try {
            itemId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID harus berupa angka");
            return;
        }
        
        System.out.print("Masukkan jumlah hari peminjaman: ");
        int days;
        try {
            days = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Hari harus berupa angka");
            return;
        }
        
        try {
            Member member = library.findMemberById(memberId);
            LibraryItem item = library.findItemById(itemId);
            
            String result = member.borrow(item, days);
            library.getLogger().logActivity(item.getTitle() + " dipinjam oleh " + member.getName());
            System.out.println(result);
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void returnItemMenu() {
        System.out.println("\nKembalikan Item:");
        
        System.out.print("Masukkan ID anggota: ");
        int memberId;
        try {
            memberId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID harus berupa angka");
            return;
        }
        
        System.out.print("Masukkan ID item: ");
        int itemId;
        try {
            itemId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID harus berupa angka");
            return;
        }
        
        System.out.print("Masukkan jumlah hari keterlambatan: ");
        int daysLate;
        try {
            daysLate = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Hari harus berupa angka");
            return;
        }
        
        try {
            Member member = library.findMemberById(memberId);
            LibraryItem item = library.findItemById(itemId);
            
            String result = member.returnItem(item, daysLate);
            library.getLogger().logActivity(item.getTitle() + " dikembalikan oleh " + member.getName());
            System.out.println(result);
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewLibraryStatus() {
        System.out.println("\nStatus Perpustakaan:");
        System.out.println(library.getLibraryStatus());
    }

    private static void viewActivityLogs() {
        System.out.println("\nLog Aktivitas:");
        System.out.println(library.getAllLogs());
    }

    private static void viewMemberBorrowedItems() {
        System.out.println("\nItem yang Dipinjam Anggota:");
        
        System.out.print("Masukkan ID anggota: ");
        int memberId;
        try {
            memberId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID harus berupa angka");
            return;
        }
        
        try {
            Member member = library.findMemberById(memberId);
            System.out.println(member.getBorrowedItems());
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}