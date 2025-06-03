package Perpustakaan_TP7.models;

public class DVD extends LibraryItem{
    private int duration; // dalam satuan menit
    private static final int MAX_BORROW_DAYS = 7;
    private static final int FINE_PER_DAY = 25_000;

    public DVD (String title, int itemId, int duration){
        super(title, itemId);

        if(duration < 0){
            throw new IllegalArgumentException("durasi tidak boleh negatif");
        }
        
        this.duration = duration;
    }

    @Override
    public String getDescription(){
        return "DVD: " + title + ", durasi " + duration + " menit, ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) throws IllegalArgumentException{
        if (days > MAX_BORROW_DAYS){
            throw new IllegalArgumentException("DVD hanya bisa dipinjam maksimal " + MAX_BORROW_DAYS + " hari");
        }
        if (isBorrowed){
            throw new IllegalArgumentException("DVD sudah dipinjam");
        }
        isBorrowed = true;
        return "item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        if (daysLate < 0) {
            throw new IllegalArgumentException("Hari keterlambatan tidak boleh negatif");
        }
        return daysLate * FINE_PER_DAY;
    }
}
