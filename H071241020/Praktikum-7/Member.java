package TP7;

import java.util.*;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) throw new IllegalStateException("Item tidak tersedia.");
        String msg = item.borrowItem(days);
        borrowedItems.add(item);
        return msg;
    }


    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) return "Item tidak ditemukan di daftar pinjaman.";
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        item.returnItem();
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + String.format("%,.0f", fine);
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam.");
            return;
        }

        System.out.println("+------+----------------------+");
        System.out.println("| ID   | Judul                |");
        System.out.println("+------+----------------------+");

        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-4d | %-20s |\n", item.getItemId(), item.getTitle());
        }

        System.out.println("+------+----------------------+");
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }
}
