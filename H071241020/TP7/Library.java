package TP7;

import java.util.*;

public class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
        logger = new LibraryLogger();
    }

    

    public String addItem(LibraryItem item) {
        for (LibraryItem existingItem : items) {
            if (existingItem.getItemId() == item.getItemId()) {
                return "Gagal: ID item " + item.getItemId() + " sudah ada.";
            }
        }
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public String addMember(Member member) {
        for (Member existingMember : members) {
            if (existingMember.getMemberId() == member.getMemberId()) {
                return "Gagal: ID anggota " + member.getMemberId() + " sudah ada.";
            }
        }
        members.add(member);
        return "Anggota " + member.getName() + " berhasil ditambahkan.";
    }


    public LibraryItem findItemById(int itemId) {
        return items.stream()
            .filter(i -> i.getItemId() == itemId)
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Item tidak ditemukan."));
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("+------+----------------------+-----------+\n");
        sb.append("| ID   | Judul                | Status    |\n");
        sb.append("+------+----------------------+-----------+\n");

        for (LibraryItem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-4d | %-20s | %-9s |\n",
                    item.getItemId(),
                    item.getTitle(),
                    status));
        }
        sb.append("+------+----------------------+-----------+");
        return sb.toString();
    }


    public String getAllLogs() {
        return logger.getLogs();
    }

    public LibraryLogger getLogger() {
        return logger;
    }

    public List<Member> getMembers() {
        return members;
    }
}
