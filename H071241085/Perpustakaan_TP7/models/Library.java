package Perpustakaan_TP7.models;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) throws IllegalArgumentException {
        // Validasi ID unik
        if (itemExists(item.getItemId())) {
            throw new IllegalArgumentException("Item dengan ID " + item.getItemId() + " sudah ada");
        }
        
        items.add(item);
        logger.logActivity("Item ditambahkan: " + item.getDescription());
        return String.format("Item '%s' berhasil ditambahkan ke perpustakaan", item.getTitle());
    }

        public LibraryItem findItemById(int itemId) throws NoSuchElementException {
        return items.stream()
            .filter(item -> item.getItemId() == itemId)
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan"));
    }

    public String addMember(Member member) throws IllegalArgumentException {
        // Validasi ID unik
        if (memberExists(member.getMemberId())) {
            throw new IllegalArgumentException("Anggota dengan ID " + member.getMemberId() + " sudah terdaftar");
        }
        
        members.add(member);
        logger.logActivity("Anggota baru: " + member.getName() + " (ID: " + member.getMemberId() + ")");
        return String.format("Anggota '%s' berhasil terdaftar", member.getName());
    }

    public Member findMemberById(int memberId) throws NoSuchElementException {
        return members.stream()
            .filter(member -> member.getMemberId() == memberId)
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Anggota dengan ID " + memberId + " tidak ditemukan"));
    }

    private boolean itemExists(int itemId) {
        return items.stream().anyMatch(item -> item.getItemId() == itemId);
    }

    private boolean memberExists(int memberId) {
        return members.stream().anyMatch(member -> member.getMemberId() == memberId);
    }


    public String getLibraryStatus() {
        if (items.isEmpty()) {
            return "Tidak ada item di perpustakaan";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("+---+---+---+\n");
        sb.append("| ID | Judul | Status |\n");
        sb.append("+---+---+---+\n");
        
        for (LibraryItem item : items) { // isborrowed being declear as getter
            String status = item.getIsBorrowed() ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %d | %s | %s |\n", 
                item.getItemId(), item.getTitle(), status));
        }
        
        sb.append("+---+---+---+\n");
        return sb.toString();
    }

    public LibraryLogger getLogger(){
        return logger;
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    // Getters
    public List<LibraryItem> getItems() {
        return items;
    }

    public List<Member> getMembers() {
        return members;
    }



}