package Perpus;
public abstract class LibraryItem {
    public String title;
    protected int itemId;
    protected boolean isBorrowed;

    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }
    public String getTitle() {
        return this.title;
    }
    public abstract String getDescription();
    public abstract String borrowItem(int days);
    public abstract double calculateFine(int daysLate);

    public String returnItem() {
        this.isBorrowed = false;
        return getTitle() + " dikembalikan";
    }
}
