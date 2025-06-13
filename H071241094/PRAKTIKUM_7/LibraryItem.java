import java.util.ArrayList;
import java.util.List;

public abstract class LibraryItem {
    protected String title;
    protected int itemId;
    protected boolean isBorrowed;

    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    public abstract String getDescription();

    public String borrowItem(int days) {
        if (isBorrowed) {
            throw new IllegalArgumentException("Item sudah dipinjam dan belum dikembalikan");
        }
        this.isBorrowed = true;
        return String.format("Item %s berhasil dipinjam selama %d hari", title, days);
    }

    public abstract double calculateFine(int daysLate);

    public String returnItem() {
        this.isBorrowed = false;
        return String.format("%s dikembalikan", title);
    }

    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}

class Book extends LibraryItem {
    private String author;
    private final int maxBorrowDays = 14;
    private final double finePerDay = 10000;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getDescription() {
        return String.format("Buku: %s oleh %s, ID: %d", title, author, itemId);
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed) {
            throw new IllegalArgumentException("Item sudah dipinjam dan belum dikembalikan");
        }
        if (days > maxBorrowDays) {
            throw new IllegalArgumentException("Melebihi batas peminjaman maksimal 14 hari");
        }
        this.isBorrowed = true;
        return String.format("Item %s berhasil dipinjam selama %d hari", title, days);
    }

    @Override
    public double calculateFine(int daysLate) {
        if (daysLate <= 0) return 0;
        return finePerDay * daysLate;
    }
}

class DVD extends LibraryItem {
    private int duration;
    private final int maxBorrowDays = 7;
    private final double finePerDay = 25000;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return String.format("DVD: %s, durasi %d menit, ID: %d", title, duration, itemId);
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed) {
            throw new IllegalArgumentException("Item sudah dipinjam dan belum dikembalikan");
        }
        if (days > maxBorrowDays) {
            throw new IllegalArgumentException("Melebihi batas peminjaman maksimal 7 hari");
        }
        this.isBorrowed = true;
        return String.format("Item %s berhasil dipinjam selama %d hari", title, days);
    }

    @Override
    public double calculateFine(int daysLate) {
        if (daysLate <= 0) return 0;
        return finePerDay * daysLate;
    }
}

class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<LibraryItem> getBorrowedItemList() {
        return borrowedItems;
    }

    public String getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            return "Tidak ada item yang dipinjam.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("+---------+----------------------+\n");
        sb.append("| ID Item | Judul                |\n");
        sb.append("+---------+----------------------+\n");

        for (LibraryItem item : borrowedItems) {
            sb.append(String.format("| %-7d | %-20s |\n",
                    item.getItemId(),
                    truncate(item.getTitle(), 20)));
        }

        sb.append("+---------+----------------------+");
        return sb.toString();
    }

    private String truncate(String text, int maxLength) {
        return text.length() <= maxLength ? text : text.substring(0, maxLength - 3) + "...";
    }

    public String borrow(LibraryItem item, int days) {
        if (borrowedItems.contains(item)) {
            return "Item sudah dipinjam oleh member ini.";
        }
        String borrowResult = item.borrowItem(days);
        borrowedItems.add(item);
        return borrowResult;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            return "Item tidak ditemukan di daftar peminjaman member";
        }
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        return String.format("Item %s berhasil dikembalikan dengan denda: Rp %, .0f", item.getTitle(), fine);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Nama: %s, Jumlah item dipinjam: %d", memberId, name, borrowedItems.size());
    }
}
