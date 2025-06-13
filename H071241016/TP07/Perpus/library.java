package Perpus;

import java.util.*;

public class library {
    private List<LibraryItem> items = new ArrayList<>();
    public List<Member> members = new ArrayList<>();
    private libraryLogger logger = new libraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.title + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
        if (item.itemId == itemId) {
            return item;
        }
    }
    throw new NoSuchElementException("Item tidak ditemukan");
    }
    
    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.memberId == memberId) {
                return member;
            }
        }
        throw new NoSuchElementException("Anggota tidak ditemukan");
    }

    public String getLibraryStatus() {
    String output = "";
    output += "+------+----------------------+-----------+\n";
    output += "| ID   | Judul                | Status    |\n";
    output += "+------+----------------------+-----------+\n";

    for (LibraryItem item : items) {
        String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
        output += String.format("| %-4d | %-20s | %-9s |\n", item.itemId, item.title, status);
    }

    output += "+------+----------------------+-----------+\n";
    return output;
}


    public String getAllLogs() {
        return logger.getLogs();
    }

    public void addMember(Member m) {
        members.add(m);
    }

    public libraryLogger getLogger() {
        return logger;
    }
}

