import java.util.Scanner;
import java.util.NoSuchElementException;

public class LibraryCLI {
    private Library library;
    private Scanner scanner;

    public LibraryCLI() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("=== SISTEM MANAJEMEN PERPUSTAKAAN ===");
        System.out.println("Selamat datang di Sistem Perpustakaan!");

        while (true) {
            showMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                handleChoice(choice);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka yang benar.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("\nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
        }
    }

    private void showMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("               MENU UTAMA");
        System.out.println("=".repeat(50));
        System.out.println("1.  Tambah Buku");
        System.out.println("2.  Tambah DVD");
        System.out.println("3.  Tambah Member");
        System.out.println("4.  Pinjam Item");
        System.out.println("5.  Kembalikan Item");
        System.out.println("6.  Lihat Status Perpustakaan");
        System.out.println("7.  Lihat Item yang Dipinjam Member");
        System.out.println("8.  Lihat Log Aktivitas");
        System.out.println("9.  Hapus Log Aktivitas");
        System.out.println("10. Keluar");
        System.out.println("=".repeat(50));
        System.out.print("Pilih menu (1-10): ");
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                addDVD();
                break;
            case 3:
                addMember();
                break;
            case 4:
                borrowItem();
                break;
            case 5:
                returnItem();
                break;
            case 6:
                showLibraryStatus();
                break;
            case 7:
                showMemberBorrowedItems();
                break;
            case 8:
                showLogs();
                break;
            case 9:
                clearLogs();
                break;
            case 10:
                exitProgram();
                break;
            default:
                System.out.println("Pilihan tidak valid! Silakan pilih menu 1-10.");
        }
    }

    private void addBook() {
        System.out.println("\n--- TAMBAH BUKU ---");
        try {
            System.out.print("Masukkan judul buku: ");
            String title = scanner.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("Judul buku tidak boleh kosong!");
                return;
            }

            System.out.print("Masukkan ID buku: ");
            int itemId = Integer.parseInt(scanner.nextLine());

            System.out.print("Masukkan nama pengarang: ");
            String author = scanner.nextLine().trim();
            if (author.isEmpty()) {
                System.out.println("Nama pengarang tidak boleh kosong!");
                return;
            }

            Book book = new Book(title, itemId, author);
            String result = library.addItem(book);
            System.out.println(result);

        } catch (NumberFormatException e) {
            System.out.println("ID buku harus berupa angka!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addDVD() {
        System.out.println("\n--- TAMBAH DVD ---");
        try {
            System.out.print("Masukkan judul DVD: ");
            String title = scanner.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("Judul DVD tidak boleh kosong!");
                return;
            }

            System.out.print("Masukkan ID DVD: ");
            int itemId = Integer.parseInt(scanner.nextLine());

            System.out.print("Masukkan durasi (dalam menit): ");
            int duration = Integer.parseInt(scanner.nextLine());
            if (duration <= 0) {
                System.out.println("Durasi harus lebih dari 0!");
                return;
            }

            DVD dvd = new DVD(title, itemId, duration);
            String result = library.addItem(dvd);
            System.out.println(result);

        } catch (NumberFormatException e) {
            System.out.println("ID dan durasi harus berupa angka!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addMember() {
        System.out.println("\n--- TAMBAH MEMBER ---");
        try {
            System.out.print("Masukkan nama member: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Nama member tidak boleh kosong!");
                return;
            }

            System.out.print("Masukkan ID member: ");
            int memberId = Integer.parseInt(scanner.nextLine());

            Member member = new Member(name, memberId);
            String result = library.addMember(member);
            System.out.println(result);

        } catch (NumberFormatException e) {
            System.out.println("ID member harus berupa angka!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void borrowItem() {
        System.out.println("\n--- PINJAM ITEM ---");
        try {
            System.out.print("Masukkan ID member: ");
            int memberId = Integer.parseInt(scanner.nextLine());

            System.out.print("Masukkan ID item: ");
            int itemId = Integer.parseInt(scanner.nextLine());

            System.out.print("Masukkan jumlah hari peminjaman: ");
            int days = Integer.parseInt(scanner.nextLine());
            if (days <= 0) {
                System.out.println("Jumlah hari harus lebih dari 0!");
                return;
            }

            String result = library.borrowItem(memberId, itemId, days);
            System.out.println(result);

        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
        } catch (NoSuchElementException | IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private void returnItem() {
        System.out.println("\n--- KEMBALIKAN ITEM ---");
        try {
            System.out.print("Masukkan ID member: ");
            int memberId = Integer.parseInt(scanner.nextLine());

            System.out.print("Masukkan ID item: ");
            int itemId = Integer.parseInt(scanner.nextLine());

            System.out.print("Masukkan jumlah hari keterlambatan (0 jika tidak terlambat): ");
            int daysLate = Integer.parseInt(scanner.nextLine());
            if (daysLate < 0) {
                System.out.println("Jumlah hari keterlambatan tidak boleh negatif!");
                return;
            }

            String result = library.returnItem(memberId, itemId, daysLate);
            System.out.println(result);

        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showLibraryStatus() {
        System.out.println("\n" + library.getLibraryStatus());
    }

    private void showMemberBorrowedItems() {
        System.out.println("\n--- ITEM YANG DIPINJAM MEMBER ---");
        try {
            System.out.print("Masukkan ID member: ");
            int memberId = Integer.parseInt(scanner.nextLine());

            Member member = library.findMemberById(memberId);
            System.out.println("\nMember: " + member.getName() + " (ID: " + member.getMemberId() + ")");
            member.getBorrowedItems();

        } catch (NumberFormatException e) {
            System.out.println("ID member harus berupa angka!");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showLogs() {
        System.out.println("\n" + library.getAllLogs());
    }

    private void clearLogs() {
        System.out.println("\n--- HAPUS LOG AKTIVITAS ---");
        System.out.print("Apakah Anda yakin ingin menghapus semua log? (y/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("y") || confirm.equals("yes")) {
            library.clearLogs();
            System.out.println("Semua log berhasil dihapus!");
        } else {
            System.out.println("Penghapusan log dibatalkan.");
        }
    }

    private void exitProgram() {
        System.out.println("\nTerima kasih telah menggunakan Sistem Manajemen Perpustakaan!");
        System.out.println("Sampai jumpa lagi!");
        scanner.close();
        System.exit(0);
    }

    public static void main(String[] args) {
        LibraryCLI cli = new LibraryCLI();
        cli.run();
    }
}