package TP7.models;

public abstract class LibraryItem {
    protected String title;
    protected int itemId;
    protected boolean isBorrowed;

    // konstruktor
    public LibraryItem(String title, int itemId) {
        // parent condition utk exception handling
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul tidak boleh kosong");
        }

        if (itemId <= 0) {
            throw new IllegalArgumentException("ID item harus bilangan positif");
        }

        this.title = title.trim();
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    // method abstrak
    public abstract String getDescription();
    public abstract String borrowItem(int days) throws IllegalArgumentException; 
        //"throws IllegalArgumentException" digunakan utk memvalidasi inputan yg tidak sesuai syarat ketentuan inputan
    public abstract double calculateFine(int daysLate);

    // method konkrit
    public String returnItem(){
        this.isBorrowed = false;
        return title + " dikembalikan";
    }

    // getters
    public String getTitle(){return title;}
    public int getItemId(){return itemId;}
    public boolean getIsBorrowed(){return isBorrowed;}
}
