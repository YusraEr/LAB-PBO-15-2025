public class Book extends LibraryItem {
    private String author;
    private static final int MAX_BORROW_DAYS = 14;
    private static final double FINE_PER_DAY = 10000.0;
    
    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }
    
    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }
    
    @Override
    public String borrowItem(int days) {
        if (days > MAX_BORROW_DAYS) {
            throw new IllegalArgumentException("Buku tidak dapat dipinjam lebih dari " + MAX_BORROW_DAYS + " hari");
        }
        if (isBorrowed) {
            throw new IllegalArgumentException("Buku " + title + " sudah dipinjam dan belum dikembalikan");
        }
        
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }
    
    @Override
    public double calculateFine(int daysLate) {
        return daysLate * FINE_PER_DAY;
    }
    
    public void printBooks() {
        System.out.println(getDescription());
    }
    
    public String getAuthor() {
        return author;
    }
}