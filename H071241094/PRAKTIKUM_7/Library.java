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

    public String addItem(LibraryItem newItem) {
        for (LibraryItem item : items) {
            if (item.getItemId() == newItem.getItemId() && item.getClass().equals(newItem.getClass())) {
                return "ID item sudah ada untuk tipe yang sama.";
            }
        }
        items.add(newItem);
        return "Item berhasil ditambahkan";
    }

    public String addMember(Member newMember) {
        for (Member m : members) {
            if (m.getMemberId() == newMember.getMemberId()) {
                return "ID anggota sudah ada.";
            }
        }
        members.add(newMember);
        return "Anggota berhasil ditambahkan";
    }

    public Member findMemberById(int id) {
        return members.stream()
                .filter(m -> m.getMemberId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Anggota dengan ID " + id + " tidak ditemukan."));
    }

    public LibraryItem findItemById(int id) {
        return items.stream()
                .filter(i -> i.getItemId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item dengan ID " + id + " tidak ditemukan."));
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("Daftar Item di Perpustakaan:\n");
        for (LibraryItem item : items) {
            sb.append(item.getDescription()).append("\n");
        }
        sb.append("\nDaftar Anggota:\n");
        for (Member m : members) {
            sb.append(m.toString()).append("\n");
        }
        return sb.toString();
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}
