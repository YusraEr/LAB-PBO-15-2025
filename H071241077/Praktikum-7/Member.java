import java.util.ArrayList;
import java.util.List;

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
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item " + item.getTitle() + " tidak tersedia (sudah dipinjam)");
        }
        
        try {
            String result = item.borrowItem(days);
            item.setBorrowed(true);
            borrowedItems.add(item);
            return result;
        } catch (IllegalArgumentException e) {
            throw e; 
        }
    }
    
    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            throw new IllegalArgumentException("Item " + item.getTitle() + " tidak ada dalam daftar peminjaman member ini");
        }
        
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        
        String formattedFine;
        if (fine == 0) {
            formattedFine = "Rp 0";
        } else {
            long fineAmount = (long) fine;
            String fineStr = String.format("%,d", fineAmount).replace(',', '.');
            formattedFine = "Rp " + fineStr;
        }
        
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: " + formattedFine;
    }
    
    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
        } else {
            System.out.println("Daftar item yang dipinjam:");
            for (int i = 0; i < borrowedItems.size(); i++) {
                System.out.println((i + 1) + ". " + borrowedItems.get(i).getDescription());
            }
        }
    }
    
    public String getName() {
        return name;
    }
    
    public int getMemberId() {
        return memberId;
    }
    
    public List<LibraryItem> getBorrowedItemsList() {
        return new ArrayList<>(borrowedItems);
    }
}