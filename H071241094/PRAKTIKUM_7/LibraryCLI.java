import java.util.Scanner;

public class LibraryCLI {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item Yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, mohon masukkan angka dari 1 sampai 8.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        addItemMenu();
                        break;
                    case 2:
                        addMemberMenu();
                        break;
                    case 3:
                        borrowItemMenu();
                        break;
                    case 4:
                        returnItemMenu();
                        break;
                    case 5:
                        System.out.println(library.getLibraryStatus());
                        break;
                    case 6:
                        System.out.println(library.getLogger().getAllLogs());
                        break;
                    case 7:
                        showBorrowedItemsByMember();
                        break;
                    case 8:
                        exit = true;
                        System.out.println("Terima kasih.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Masukkan angka dari 1 sampai 8.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addItemMenu() {
        System.out.print("Jenis item (1: Buku, 2: DVD): ");
        String type = scanner.nextLine();
        System.out.print("Masukkan judul: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan ID item: ");
        int id = Integer.parseInt(scanner.nextLine());

        String result;
        if (type.equals("1")) {
            System.out.print("Masukkan nama author: ");
            String author = scanner.nextLine();
            Book book = new Book(title, id, author);
            result = library.addItem(book);
            System.out.println(result);
            if (result.equals("Item berhasil ditambahkan")) {
                library.getLogger().logActivity(String.format("Item Buku '%s' berhasil ditambahkan", title));
            }
        } else if (type.equals("2")) {
            System.out.print("Masukkan durasi (menit): ");
            int duration = Integer.parseInt(scanner.nextLine());
            DVD dvd = new DVD(title, id, duration);
            result = library.addItem(dvd);
            System.out.println(result);
            if (result.equals("Item berhasil ditambahkan")) {
                library.getLogger().logActivity(String.format("Item DVD '%s' berhasil ditambahkan", title));
            }
        } else {
            System.out.println("Jenis item tidak valid.");
        }
    }

    private static void addMemberMenu() {
        System.out.print("Masukkan nama Anggota: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan ID Anggota: ");
        int id = Integer.parseInt(scanner.nextLine());
        Member member = new Member(name, id);
        String result = library.addMember(member);
        System.out.println(result);
        if (result.equals("Anggota berhasil ditambahkan")) {
            library.getLogger().logActivity(String.format("Anggota '%s' ditambahkan", name));
        }
    }

    private static void borrowItemMenu() {
        System.out.print("Masukkan ID Anggota: ");
        int memberId = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan ID Item: ");
        int itemId = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan lama pinjam (hari): ");
        int days = Integer.parseInt(scanner.nextLine());

        try {
            Member member = library.findMemberById(memberId);
            LibraryItem item = library.findItemById(itemId);
            String message = member.borrow(item, days);
            System.out.println(message);
            library.getLogger().logActivity(String.format("Item '%s' dipinjam oleh anggota '%s'", item.getTitle(), member.getName()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void returnItemMenu() {
        System.out.print("Masukkan ID Anggota: ");
        int memberId = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan ID Item: ");
        int itemId = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan jumlah hari keterlambatan: ");
        int daysLate = Integer.parseInt(scanner.nextLine());

        try {
            Member member = library.findMemberById(memberId);
            LibraryItem item = library.findItemById(itemId);
            String message = member.returnItem(item, daysLate);
            System.out.println(message);
            library.getLogger().logActivity(String.format("Item '%s' dikembalikan oleh anggota '%s'", item.getTitle(), member.getName()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void showBorrowedItemsByMember() {
        System.out.print("Masukkan ID Anggota: ");
        int memberId = Integer.parseInt(scanner.nextLine());

        try {
            Member member = library.findMemberById(memberId);
            System.out.println(member.getBorrowedItems());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
