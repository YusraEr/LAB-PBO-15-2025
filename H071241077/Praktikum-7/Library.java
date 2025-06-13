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

    public String addItem(LibraryItem item) {
        for (LibraryItem existingItem : items) {
            if (existingItem.getItemId() == item.getItemId()) {
                return "Item dengan ID " + item.getItemId() + " sudah ada dalam perpustakaan";
            }
        }

        items.add(item);
        String activity = item.getDescription() + " berhasil ditambahkan";
        logger.logActivity(activity);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public String addMember(Member member) {
        for (Member existingMember : members) {
            if (existingMember.getMemberId() == member.getMemberId()) {
                return "Member dengan ID " + member.getMemberId() + " sudah ada";
            }
        }

        members.add(member);
        logger.logActivity("Member " + member.getName() + " (ID: " + member.getMemberId() + ") berhasil ditambahkan");
        return "Member " + member.getName() + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan");
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        throw new NoSuchElementException("Member dengan ID " + memberId + " tidak ditemukan");
    }

    public String borrowItem(int memberId, int itemId, int days) {
        try {
            Member member = findMemberById(memberId);
            LibraryItem item = findItemById(itemId);

            String result = member.borrow(item, days);

            String itemType = (item instanceof Book) ? "Buku" : "DVD";
            logger.logActivity(itemType + " '" + item.getTitle() + "' dipinjam oleh " + member.getName());

            return result;
        } catch (Exception e) {
            throw e;
        }
    }

    public String returnItem(int memberId, int itemId, int daysLate) {
        try {
            Member member = findMemberById(memberId);
            LibraryItem item = findItemById(itemId);

            String result = member.returnItem(item, daysLate);

            String itemType = (item instanceof Book) ? "Buku" : "DVD";
            logger.logActivity(itemType + " '" + item.getTitle() + "' dikembalikan oleh " + member.getName() +
                    (daysLate > 0 ? " (terlambat " + daysLate + " hari)" : ""));

            return result;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getLibraryStatus() {
        if (items.isEmpty()) {
            return "Perpustakaan kosong";
        }

        int maxLength = "STATUS PERPUSTAKAAN".length();
        List<String> lines = new ArrayList<>();

        for (LibraryItem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            String line = item.getDescription() + " - Status: " + status;
            lines.add(line);
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }

        maxLength += 4;

        StringBuilder sb = new StringBuilder();

        sb.append("┌");
        for (int i = 0; i < maxLength; i++) {
            sb.append("─");
        }
        sb.append("┐\n");

        String headerText = "STATUS PERPUSTAKAAN";
        int headerPadding = (maxLength - headerText.length()) / 2;
        sb.append("│");
        for (int i = 0; i < headerPadding; i++) {
            sb.append(" ");
        }
        sb.append(headerText);
        for (int i = 0; i < maxLength - headerPadding - headerText.length(); i++) {
            sb.append(" ");
        }
        sb.append("│\n");

        sb.append("├");
        for (int i = 0; i < maxLength; i++) {
            sb.append("─");
        }
        sb.append("┤\n");

        for (String line : lines) {
            sb.append("│ ");
            sb.append(line);
            for (int i = 0; i < maxLength - line.length() - 2; i++) {
                sb.append(" ");
            }
            sb.append(" │\n");
        }

        sb.append("└");
        for (int i = 0; i < maxLength; i++) {
            sb.append("─");
        }
        sb.append("┘");

        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public void clearLogs() {
        logger.clearLogs();
    }

    public List<LibraryItem> getItems() {
        return new ArrayList<>(items);
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }
}