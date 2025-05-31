package Perpus;

import java.util.*;

public class Member {
    private String name; 
    public int memberId; 
    private List<LibraryItem> borrowedItems = new ArrayList<>(); 

    
    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    
    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed) {
            throw new IllegalStateException("Item tidak tersedia untuk dipinjam");
        }
        String hasil = item.borrowItem(days); 
        borrowedItems.add(item); 
        return hasil;
    }

    
    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            return "Item tidak dipinjam oleh anggota ini.";
        }
        double denda = item.calculateFine(daysLate); 
        borrowedItems.remove(item); 
        item.returnItem(); 
        return "Item " + item + " berhasil dikembalikan dengan denda: Rp " + (int) denda;
    }

    
    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam saat ini.");
        } else {
    String output = "";
    output += "+------+----------------------+\n";
    output += "| ID   | Judul                |\n";
    output += "+------+----------------------+\n";

    for (LibraryItem item : borrowedItems) {
                output += String.format("| %-4d | %-20s |\n", item.itemId, item.title);
            }

    output += "+------+----------------------+\n";
    System.out.println(output);
}

            
        }
    

   
    public String getName() {
        return name;
    }
}

