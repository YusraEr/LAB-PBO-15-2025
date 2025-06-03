package Perpustakaan_TP7.models;

public class Book extends LibraryItem{
    private String author;
    private static final int MAX_BORROW_DAYS = 14;
    private static final double FINE_PER_DAY = 10_000;

    public Book(String title, int itemId, String author) {
        super(title, itemId);

        // exception handling dari parent class lgsg
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Penulis tidak boleh kosong");
        }
        
        this.author = author.trim();
    }


    @Override
    public String getDescription(){
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) throws IllegalArgumentException{
        if (days > MAX_BORROW_DAYS){
            throw new IllegalArgumentException("Buku hanya bisa dipinjam maksimal " + MAX_BORROW_DAYS + " hari.");
        }
        if (isBorrowed){
            throw new IllegalArgumentException("Buku sudah dipinjam");
        }
        isBorrowed = true;
        return "item " + title + " berhasil dipinjam selama " + days + " hari";
        
    }
    // pengendalian error atau exception jika ada argumen u


@Override
    public double calculateFine(int daysLate) {
        if (daysLate < 0) {
            throw new IllegalArgumentException("Hari keterlambatan tidak boleh negatif");
        }
        return daysLate * FINE_PER_DAY;
    }

    // getter author
    public String getAuthor(){return author;}

}
