package Perpustakaan_TP7.models;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId){
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) throws IllegalArgumentException{
        try {
            String result = item.borrowItem(days);
            borrowedItems.add(item);
            return "item " + item.getTitle() + " berhasil dipinjam selama " + days + " hari";
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public String returnItem(LibraryItem item, int daysLate){
        String returnMessage = item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        return "item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + String.format("%,.0f", fine);
    }

    public String getBorrowedItems(){
        if (borrowedItems.isEmpty()){
            return "tidak ada item yang dipinjam";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("===+===+===\n");
        sb.append("| ID | Judul |\n");
        sb.append("===+===+===\n");

        for (LibraryItem item : borrowedItems){
            sb.append(String.format("| %d | %s |\n", item.getItemId(), item.getTitle()));
        }

        sb.append("===+===+===\n");
        return sb.toString();
    }

    // getter
    public String getName(){return name;}
    public int getMemberId(){return memberId;}
}
